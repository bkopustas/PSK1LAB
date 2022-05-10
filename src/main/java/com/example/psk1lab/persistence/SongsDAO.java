package com.example.psk1lab.persistence;

import com.example.psk1lab.entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SongsDAO {

    @Inject
    private EntityManager em;


    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Song song){
        this.em.persist(song);
    }

    public Song findOne(Integer id) {
        return em.find(Song.class, id);
    }

    public Song update(Song song){
        return em.merge(song);
    }
}
