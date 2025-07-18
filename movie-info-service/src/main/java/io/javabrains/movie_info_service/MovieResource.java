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

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
        // Simulate fetching movie data from a TMDB database
        MovieSummary movieSummary = webClientBuilder.build()
                .get()
                .uri("https://api.themoviedb.org/3/movie/" + movieId)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZmRjM2EzNjlhZjM0ODcwZWNhNzU0ZjhjNTVkOGI1ZSIsIm5iZiI6MTY3NzgwOTgyNy4xMjYwMDAyLCJzdWIiOiI2NDAxNThhMzY5OWZiNzAwOTYwMDQ1ZTciLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.-HmpuEb_Mq5myljcoKYIIRlB4c8kcDsA2Re5zeNAN0U")
                .retrieve()
                .bodyToMono(MovieSummary.class)     // Reactive wrapper
                .block();

        return new Movie(movieSummary.getId(), movieSummary.getTitle(), movieSummary.getOverview());
    }
}
