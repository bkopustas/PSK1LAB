package com.example.psk1lab.persistence;

import com.example.psk1lab.entities.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ArtistDAO {

    @Inject
    private EntityManager entityManager;

    public List<Artist> loadAll() {return entityManager.createNamedQuery("Artist.findAll", Artist.class).getResultList();}

    public void setEm(EntityManager entityManager) {this.entityManager = entityManager;}

    public void persist(Artist artist) {this.entityManager.persist(artist);}

    public Artist findOne(Long id) {return entityManager.find(Artist.class, id);}

    public Artist update(Artist artist){
        return entityManager.merge(artist);
    }
}