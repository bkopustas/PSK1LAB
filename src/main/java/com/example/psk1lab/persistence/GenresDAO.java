package com.example.psk1lab.persistence;

import com.example.psk1lab.entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@ApplicationScoped
public class GenresDAO {

    @Inject
    private EntityManager em;

    public void persist(Genre genre) {
        this.em.persist(genre);
    }

    public Genre findOne(Integer id) {
        return em.find(Genre.class, id);
    }

    public List<Genre> loadAll() {
        return em.createNamedQuery("Genre.findAll", Genre.class).getResultList();
    } //

    public Genre findByGenreName(String genreName) {
        try {
            return em.createNamedQuery("Genre.findOne", Genre.class)
                    .setParameter("genreName", genreName)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }
}