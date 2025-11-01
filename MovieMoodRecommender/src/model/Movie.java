package model;

public class Movie {
    private String title;
    private String releaseDate;
    private double rating;
    private String overview;

    // Constructor
    public Movie(String title, String releaseDate, double rating, String overview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.overview = overview;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public String getOverview() {
        return overview;
    }

    // toString() for easy display
    @Override
    public String toString() {
        return title + " (" + releaseDate + ") - Rating: " + rating + "\n" + overview;
    }
}