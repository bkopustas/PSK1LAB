package com.example.psk1lab.persistence;

import com.example.psk1lab.entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class SongDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(Song song) {
        this.entityManager.persist(song);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Song findOne(Long id){
        return entityManager.find(Song.class, id);
    }

    public Song update(Song song){
        return entityManager.merge(song);
    }

}
