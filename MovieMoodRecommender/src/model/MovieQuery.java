package model;

import java.util.List;

public class MovieQuery {
    private List<Integer> genreIds;
    private Integer storyKeyword;
    private Integer themeKeyword;
    private String sortOption;

    public MovieQuery(List<Integer> genreIds, Integer storyKeyword, Integer themeKeyword, String sortOption) {
        this.genreIds = genreIds;
        this.storyKeyword = storyKeyword;
        this.themeKeyword = themeKeyword;
        this.sortOption = sortOption;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public Integer getStoryKeyword() {
        return storyKeyword;
    }

    public Integer getThemeKeyword() {
        return themeKeyword;
    }

    public String getSortOption() {
        return sortOption;
    }
}