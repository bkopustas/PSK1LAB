package com.example.psk1lab.usecases;

import com.example.psk1lab.mybatis.model.Genre;
import com.example.psk1lab.mybatis.dao.GenreMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class GenresAndSongsMB implements Serializable {
    @Inject
    private GenreMapper GenreMapper;

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
        GenreMapper.insert(genreToCreate);
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    private void loadAllGenres() {
        allGenres = GenreMapper.selectAll();
    }
}
