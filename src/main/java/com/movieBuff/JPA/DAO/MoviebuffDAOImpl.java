package com.movieBuff.JPA.DAO;

import com.movieBuff.JPA.Entity.MoviesDetails;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MoviebuffDAOImpl implements MoviebuffDAO{

    EntityManager entityManager;

    @Autowired
    public MoviebuffDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addNewDetails(MoviesDetails newMovie) {
            entityManager.persist(newMovie);
    }

    @Override
    public void desplaybyCustomerId(int id) {

    }
}
