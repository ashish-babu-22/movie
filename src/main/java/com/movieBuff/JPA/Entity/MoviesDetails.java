package com.movieBuff.JPA.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies_details")
public class MoviesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;


    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "actor")
    private String actor;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "theatreId")
    private TheatreDetails theatreDetails;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "mv_id")
    private List<ReviewDetails> reviewDetailsList;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,
                    CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="customer_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<CustomerDetails> customerDetails;
    public MoviesDetails(){}

    public List<ReviewDetails> getReviewDetailsList() {
        return reviewDetailsList;
    }

    public void setReviewDetailsList(List<ReviewDetails> reviewDetailsList) {
        this.reviewDetailsList = reviewDetailsList;
    }

    public MoviesDetails(String name, String duration, String actor) {
        this.name = name;
        this.duration = duration;
        this.actor = actor;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public List<ReviewDetails> getReviewDetails() {
        return reviewDetailsList;
    }

    public void setReviewDetails(List<ReviewDetails> reviewDetails) {
        this.reviewDetailsList = reviewDetails;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public TheatreDetails getTheatreDetails() {
        return theatreDetails;
    }

    public void setTheatreDetails(TheatreDetails theatreDetails) {
        this.theatreDetails = theatreDetails;
    }

    public List<CustomerDetails> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetails> customerDetails) {
        this.customerDetails = customerDetails;
    }
    public void add(ReviewDetails newReview){
        if(reviewDetailsList == null)
            reviewDetailsList = new ArrayList<>();
        reviewDetailsList.add(newReview);

    }

  public void add(CustomerDetails newCus){
        if(customerDetails==null)
            customerDetails = new ArrayList<>();

        customerDetails.add(newCus);
  }

    @Override
    public String toString() {
        return "MovieDetails{" +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", actor='" + actor + '\'' +
                ", theatreDetails=" + theatreDetails +
                '}';
    }
}
