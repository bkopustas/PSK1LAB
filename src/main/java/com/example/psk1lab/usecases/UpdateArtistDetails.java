package com.example.psk1lab.usecases;

import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.interceptors.LoggedInvocation;
import com.example.psk1lab.persistence.ArtistDAO;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateArtistDetails implements Serializable{
    private Artist artist;

    @Inject
    private ArtistDAO artistDAO;

    @Inject
    private EntityManager entityManager;

    @PostConstruct
    private void init() {
        System.out.println("----------UpdateArtistDetails INIT CALLED----------");
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long artistId = Long.parseLong(requestParameters.get("artistId"));
        this.artist = artistDAO.findOne(artistId);
    }

    @Transactional
    @LoggedInvocation
    public String updateArtistName() {
        try {
            artistDAO.update(this.artist);
        } catch (OptimisticLockException e) {
            System.out.println(this.artist.getId());
            return "artistDetails?faces-redirect=true&artistId=" + this.artist.getId() + "&error=optimistic-lock-exception";
        }
        return "artists?faces-redirect=true";

    }
}
