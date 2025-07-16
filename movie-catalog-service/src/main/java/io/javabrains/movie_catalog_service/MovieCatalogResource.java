package io.javabrains.movie_catalog_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // 1. Get hardcoded Ratings Data
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("456", 5)
        );

        // 2. Enrich each rating by fetching movie info
        return ratings.stream()
                .map(r -> {
                    Movie movie = restTemplate.getForObject(
                            "http://localhost:8082/movies/" + r.getMovieId(),
                            Movie.class
                    );
                    return new CatalogItem(movie.getName(), movie.getDescription(), r.getRating());
                })
                .collect(Collectors.toList());
    }
}
