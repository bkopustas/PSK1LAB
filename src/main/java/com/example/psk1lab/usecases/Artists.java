package com.example.psk1lab.usecases;

import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.persistence.ArtistDAO;
import lombok.Getter;
import lombok.Setter;
import org.mybatis.cdi.Mapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Artists implements Serializable {
    @Inject
    private ArtistDAO artistDAO;

    @Getter
    @Setter
    private Artist artistToCreate = new Artist();

    @Getter
    private List<Artist> allArtists;

    @PostConstruct
    public void init() {
        loadAccounts();
    }

    public void loadAccounts() {
        this.allArtists = artistDAO.loadAll();
    }

    @Transactional
    public String createArtist() {
        this.artistDAO.persist(artistToCreate);
        return "index?faces-redirect=true";
    }

}
