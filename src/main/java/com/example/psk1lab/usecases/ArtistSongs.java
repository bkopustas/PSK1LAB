package com.example.psk1lab.usecases;

import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.entities.Song;
import com.example.psk1lab.persistence.ArtistDAO;
import com.example.psk1lab.persistence.SongDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class ArtistSongs implements Serializable {
    @Inject
    private ArtistDAO artistDAO;

    @Inject
    private SongDAO songDAO;

    @Getter
    @Setter
    private Artist artist;

    @Getter
    @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long artistId = Long.parseLong(requestParameters.get("artistId"));
        this.artist = artistDAO.findOne(artistId);
    }

    @Transactional
    public String createSong() {
        songToCreate.setArtist(this.artist);
        songDAO.persist(songToCreate);
        return "songs?faces-redirect=true&artistId=" + this.artist.getId();
    }

}
