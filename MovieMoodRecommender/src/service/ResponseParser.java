package service;

import model.Movie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResponseParser {

    public static List<Movie> parseMovies(String json) {
        List<Movie> movies = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray results = obj.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject m = results.getJSONObject(i);

                String title = m.optString("title", "No title");
                String release = m.optString("release_date", "Unknown");
                double rating = m.optDouble("vote_average", 0.0);
                String overview = m.optString("overview", "");

                movies.add(new Movie(title, release, rating, overview));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }
}