package io.javabrains.movie_info_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    // Inject and use WebClient
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private TMDBConfiguration tmdbConfiguration;

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
        System.out.println("Selected language is:"+tmdbConfiguration.getLang());
        // Simulate fetching movie data from a TMDB database
        MovieSummary movieSummary = webClientBuilder.build()
                .get()
                .uri(tmdbConfiguration.getUrl() + movieId)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, tmdbConfiguration.getApiKey())
                .retrieve()
                .bodyToMono(MovieSummary.class)     // Reactive wrapper
                .block();

        return new Movie(movieSummary.getId(), movieSummary.getTitle(), movieSummary.getOverview());
    }
}
