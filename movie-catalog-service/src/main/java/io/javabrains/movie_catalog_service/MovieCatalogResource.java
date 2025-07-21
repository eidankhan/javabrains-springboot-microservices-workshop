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
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // 1. Get hardcoded Ratings Data
        UserRating userRating = getUserRating(userId);

        // 2. Enrich each rating by fetching movie info
        assert userRating != null;
        return userRating.getRatings().stream()
                .map(this::getCatalogItem)
                .collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    private CatalogItem getCatalogItem(Rating r) {
        Movie movie = webClientBuilder.build()
                .get()
                .uri("http://MOVIE-INFO-SERVICE/movies/" + r.getMovieId())
                .retrieve()
                .bodyToMono(Movie.class)     // Reactive wrapper
                .block();
        return new CatalogItem(movie.getName(), movie.getDescription(), r.getRating());
    }

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    private UserRating getUserRating(String userId) {
        return restTemplate.getForObject(
                "http://MOVIE-RATING-SERVICE/ratings-data/users/" + userId,
                UserRating.class
        );
    }

    private List<CatalogItem> getFallbackCatalogItem(){
        return Arrays.asList(new CatalogItem("No Movie", "", 0));
    }

    private UserRating getFallbackUserRating(){
        return new UserRating(Arrays.asList(new Rating("Movie Not found",0)));
    }

}
