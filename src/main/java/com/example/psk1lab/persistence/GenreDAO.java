package com.example.psk1lab.persistence;

import com.example.psk1lab.entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@ApplicationScoped
public class GenreDAO {

    @Inject
    private EntityManager entityManager;

    public List<Genre> loadAll() {
        return entityManager.createNamedQuery("Genre.findAll", Genre.class).getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Genre genre) {
        this.entityManager.persist(genre);
    }

    public Genre findOne(Long id) {
        return entityManager.find(Genre.class, id);
    }

    public Genre findByName(String name) {
        try {
            return entityManager.createNamedQuery("Genre.findOne", Genre.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }
}