package com.movieBuff.JPA.DAO;

import com.movieBuff.JPA.Entity.MoviesDetails;

public interface MoviebuffDAO {

    public void addNewDetails(MoviesDetails newMovie);
    public void desplaybyCustomerId(int id);


}
