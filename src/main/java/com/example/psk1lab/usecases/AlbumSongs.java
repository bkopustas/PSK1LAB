package com.example.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import com.example.psk1lab.entities.Album;
import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.entities.Song;
import com.example.psk1lab.persistence.AlbumsDAO;
import com.example.psk1lab.persistence.ArtistsDAO;
import com.example.psk1lab.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class AlbumSongs implements Serializable {

    @Inject
    private SongsDAO songsDAO;

    @Inject
    private AlbumsDAO albumsDAO;

    @Getter @Setter
    private Album album;

    @Getter @Setter
    private Song songToCreate = new Song();

    @Getter @Setter
    private List<Artist> artistList;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumsDAO.findOne(albumId);
    }

    @Transactional
    public void createSong(){
        songToCreate.setAlbum(this.album);
        songToCreate.setArtist_id(this.album.getArtist().getArtist_id());
        songsDAO.persist(songToCreate);
    }
}
