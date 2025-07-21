package io.javabrains.movie_catalog_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieInfoService {
    // Inject and use WebClient
    @Autowired
    private WebClient.Builder webClientBuilder;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating r) {
        Movie movie = webClientBuilder.build()
                .get()
                .uri("http://MOVIE-INFO-SERVICE/movies/" + r.getMovieId())
                .retrieve()
                .bodyToMono(Movie.class)     // Reactive wrapper
                .block();
        return new CatalogItem(movie.getName(), movie.getDescription(), r.getRating());
    }

    private CatalogItem getFallbackCatalogItem(Rating r){
        return new CatalogItem("No Movie", "", r.getRating());
    }
}
