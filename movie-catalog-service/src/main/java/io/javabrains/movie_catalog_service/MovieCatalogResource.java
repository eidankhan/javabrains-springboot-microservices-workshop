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
    private UserRatingService userRatingService;

    @Autowired
    private MovieInfoService movieInfoService;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // 1. Get hardcoded Ratings Data
        UserRating userRating = userRatingService.getUserRating(userId);

        // 2. Enrich each rating by fetching movie info
        assert userRating != null;
        return userRating.getRatings().stream()
                .map(r -> movieInfoService.getCatalogItem(r))
                .collect(Collectors.toList());
    }
}
