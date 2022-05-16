package com.example.psk1lab.usecases;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;
import com.example.psk1lab.mybatis.dao.GenreMapper;
import com.example.psk1lab.mybatis.model.Genre;

@Model
public class GenresAndSongsMB implements Serializable {

    @Inject
    private GenreMapper genreMapper;

    @Getter
    private List<Genre> allGenres;

    @Getter
    @Setter
    private Genre genreToCreate = new Genre();

    @PostConstruct
    private void init() {
        loadAllGenres();
    }

    @Transactional
    public String createGenre() {
        genreMapper.insert(genreToCreate);
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    private void loadAllGenres() {
        allGenres = genreMapper.selectAll();
    }
}