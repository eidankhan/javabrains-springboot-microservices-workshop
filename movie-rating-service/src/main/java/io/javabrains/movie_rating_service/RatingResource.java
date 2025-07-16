package io.javabrains.movie_rating_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings-data")
public class RatingResource {

    @GetMapping("/{movieId}")
    public Rating getRatingData(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }
}
