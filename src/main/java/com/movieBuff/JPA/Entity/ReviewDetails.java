package com.movieBuff.JPA.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews_details")
public class ReviewDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;
    @Column(name = "review")
    private String review;

    public ReviewDetails(){}

    public ReviewDetails(String review) {
        this.review = review;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ReviewDetails{" +
                "reviewId=" + reviewId +
                ", review='" + review + '\'' +
                  '}';
    }
}
