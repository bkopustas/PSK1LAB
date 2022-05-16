package com.example.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import com.example.psk1lab.entities.Genre;
import com.example.psk1lab.persistence.GenresDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Genres implements Serializable {
    @Inject
    private GenresDAO genreDAO;

    @Getter
    @Setter
    private Genre genreToCreate = new Genre();

    @Getter
    private List<Genre> allGenres;

    @PostConstruct
    public void init() {
        loadGenres();
    }

    public void loadGenres() {
        this.allGenres = genreDAO.loadAll();
    }

    @Transactional
    public String createGenre() {
        this.genreDAO.persist(genreToCreate);
        return "index?faces-redirect=true";
    }
}