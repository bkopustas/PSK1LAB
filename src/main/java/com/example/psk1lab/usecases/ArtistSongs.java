package com.example.psk1lab.usecases;

import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.entities.Song;
import com.example.psk1lab.persistence.ArtistsDAO;
import com.example.psk1lab.persistence.SongsDAO;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.JoinColumn;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Map;

@Model
public class ArtistSongs implements Serializable {

    @Inject
    private ArtistsDAO artistsDAO;

    @Inject
    private SongsDAO songsDAO;

    @Setter @Getter
    private Artist artist;

    @Getter @Setter
    private Song songToCreate = new Song();



    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));
        this.artist = artistsDAO.findOne(artistId);
    }

    @Transactional
    public String createSong() {
        songToCreate.setArtist(this.artist);
        songsDAO.persist(songToCreate);
        return "songs?faces-redirect=true&artistId=" + this.artist.getId();
    }

}