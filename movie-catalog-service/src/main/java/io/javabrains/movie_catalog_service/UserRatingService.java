package io.javabrains.movie_catalog_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject(
                "http://MOVIE-RATING-SERVICE/ratings-data/users/" + userId,
                UserRating.class
        );
    }

    private UserRating getFallbackUserRating(String userId){
        return new UserRating(Arrays.asList(new Rating("Movie Not found",0)));
    }
}
