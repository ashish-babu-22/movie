package com.movieBuff.JPA.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name ="phone")
    private String phone;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "customer_movie",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<MoviesDetails> moviesDetailsList;
    public CustomerDetails(){}

    public CustomerDetails(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<MoviesDetails> getMovieDetailsList() {
        return moviesDetailsList;
    }

    public void setMovieDetailsList(List<MoviesDetails> moviesDetailsList) {
        this.moviesDetailsList = moviesDetailsList;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", movieDetailsList=" + moviesDetailsList +
                '}';
    }

    public void add(MoviesDetails newMovie){
        if(moviesDetailsList == null)
            moviesDetailsList = new ArrayList<>();

        moviesDetailsList.add(newMovie);

    }


}
