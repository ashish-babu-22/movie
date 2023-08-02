package com.movieBuff.JPA.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "owner_details")
public class OwnerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private TheatreDetails theatreDetails;

    public OwnerDetails(){}

    public OwnerDetails(String name, String phone) {
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

    public TheatreDetails getTheatreDetails() {
        return theatreDetails;
    }

    public void setTheatreDetails(TheatreDetails theatreDetails) {
        this.theatreDetails = theatreDetails;
    }

    @Override
    public String toString() {
        return "OwnerDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", theatreDetails=" + theatreDetails +
                '}';
    }
}
