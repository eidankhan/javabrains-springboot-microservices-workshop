package io.javabrains.movie_catalog_service;

import java.util.List;

public class UserRating {
    private List<Rating> ratings;

    private UserRating(){}

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}

