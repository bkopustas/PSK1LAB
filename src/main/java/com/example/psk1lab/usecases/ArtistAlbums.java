package com.example.psk1lab.usecases;

import lombok.Getter;
import lombok.Setter;
import com.example.psk1lab.entities.Album;
import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.persistence.AlbumsDAO;
import com.example.psk1lab.persistence.ArtistsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class ArtistAlbums implements Serializable {

    @Inject
    private AlbumsDAO albumsDAO;

    @Inject
    private ArtistsDAO artistsDAO;

    @Getter @Setter
    private Artist artist;

    @Getter @Setter
    private Album albumToCreate = new Album();

    @PostConstruct
    public void init(){
        Map<String,String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));
        this.artist = artistsDAO.findOne(artistId);
    }

    @Transactional
    public void createAlbum(){
        albumToCreate.setArtist(this.artist);
        albumToCreate.setAlbum_artist(this.artist.getArtist_name());
        albumsDAO.persist(albumToCreate);
    }

}