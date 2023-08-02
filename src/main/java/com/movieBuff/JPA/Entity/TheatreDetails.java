package com.movieBuff.JPA.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatre_details")
public class TheatreDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private int theatreId;

    @Column(name = "name")
    private String name;

    @Column(name = "venue")
    private String venue;


    @OneToOne(mappedBy = "theatreDetails", fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private OwnerDetails ownerDetails;

    @OneToMany(mappedBy = "theatreDetails")
    private List<MoviesDetails> moviesDetailsList;

    public TheatreDetails(){}

    public TheatreDetails(String name, String venue) {
        this.name = name;
        this.venue = venue;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public OwnerDetails getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(OwnerDetails ownerDetails) {
        this.ownerDetails = ownerDetails;
    }

    public List<MoviesDetails> getMovieDetailsList() {
        return moviesDetailsList;
    }

    public void setMovieDetailsList(List<MoviesDetails> moviesDetailsList) {
        this.moviesDetailsList = moviesDetailsList;
    }

    @Override
    public String toString() {
        return "TheatreDetails{" +
                "theatreId=" + theatreId +
                ", name='" + name + '\'' +
                ", venue='" + venue + '\'' +
                ", ownerId=" +ownerDetails +
                '}';
    }

    //convenience method

    public void add(MoviesDetails newMovie){
        if(moviesDetailsList ==null){
            moviesDetailsList = new ArrayList<>();
        }
        moviesDetailsList.add(newMovie);
        newMovie.setTheatreDetails(this);
    }
}
