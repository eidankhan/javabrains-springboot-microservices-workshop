package io.javabrains.movie_catalog_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    // Inject and use WebClient
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // 1. Get hardcoded Ratings Data
        UserRating userRating = restTemplate.getForObject(
                            "http://MOVIE-RATING-SERVICE/ratings-data/users/" + userId,
                            UserRating.class
                    );

        // 2. Enrich each rating by fetching movie info
        assert userRating != null;
        return userRating.getRatings().stream()
                .map(r -> {
//                    Movie movie = restTemplate.getForObject(
//                            "http://localhost:8082/movies/" + r.getMovieId(),
//                            Movie.class
//                    );

                    Movie movie = webClientBuilder.build()
                            .get()
                            .uri("http://MOVIE-INFO-SERVICE/movies/" + r.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class)     // Reactive wrapper
                            .block();
                    return new CatalogItem(movie.getName(), movie.getDescription(), r.getRating());
                })
                .collect(Collectors.toList());
    }

    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
        return Arrays.asList(
                new CatalogItem("No movie", "", 0)
        );
    }
}
