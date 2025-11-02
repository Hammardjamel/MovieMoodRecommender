package service;

import model.MovieQuery;
import java.util.List;
import java.util.stream.Collectors;

public class TMDBUrlBuilder {

    private static final String API_KEY = "7509fb2ae5b68bd2f0264da1a0b0d1af";
    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/movie";

    public static String buildDiscoverUrl(MovieQuery query) {

        List<Integer> genreIds = query.getGenreIds();
        String primaryGenreParam = "";
        if (!genreIds.isEmpty()) {
            primaryGenreParam = "&with_genres=" + genreIds.get(0);
        }
    
        String sortParam = "&sort_by=" + query.getSortOption();
        String releaseYearFilter = "&primary_release_date.gte=2000-01-01";
    
        return BASE_URL + "?api_key=" + API_KEY
                + primaryGenreParam
                + sortParam
                + releaseYearFilter;
    }
}