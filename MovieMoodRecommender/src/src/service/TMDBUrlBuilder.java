package service;

import model.MovieQuery;
import java.util.List;
import java.util.stream.Collectors;

public class TMDBUrlBuilder {

    private static final String API_KEY = "7509fb2ae5b68bd2f0264da1a0b0d1af"; // devloper key
    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/movie";

    public static String buildDiscoverUrl(MovieQuery query) {

        // convert genre list to comma separated string
        List<Integer> genreIds = query.getGenreIds();
        String genresParam = genreIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        Integer storyKeyword = query.getStoryKeyword();
        

        // keywords combined (story + theme)
        String keywordParam = "";

        

        // theme keyword ignored for now
        
        if (storyKeyword != null) {
            keywordParam = "&with_keywords=" + storyKeyword;
        }

        String sortParam = "&sort_by=" + query.getSortOption();

        String releaseYearFilter = "&primary_release_date.gte=2000-01-01";

        return BASE_URL + "?api_key=" + API_KEY
                + "&with_genres=" + genresParam
                + keywordParam
                + sortParam
                + releaseYearFilter;
    }
}