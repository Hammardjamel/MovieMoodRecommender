package service;

import model.MovieQuery;
import java.util.ArrayList;
import java.util.List;

public class MovieQueryBuilder {

    private String mood;
    private String storyType;
    private String pace;
    //private String vibe;
    private String theme;

    public MovieQueryBuilder setMood(String mood) {
        this.mood = mood;
        return this;
    }

    public MovieQueryBuilder setStoryType(String storyType) {
        this.storyType = storyType;
        return this;
    }

    public MovieQueryBuilder setPace(String pace) {
        this.pace = pace;
        return this;
    }

    //public MovieQueryBuilder setVibe(String vibe) {
       // this.vibe = vibe;
      //  return this;
    //}

    public MovieQueryBuilder setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public MovieQuery build() {
        // 1) genres
        List<Integer> genreIds = new ArrayList<>();
        genreIds.addAll(MoodGenreMapping.getGenresForMood(mood));
        //Integer vibeGenre = VibeGenreMapping.getGenreForVibe(vibe);
        //if (vibeGenre != null) {
            //genreIds.add(vibeGenre);
         //}

        // 2) story keyword
        Integer storyKeyword = StoryKeywordMapping.getKeywordForStory(storyType);

        // 3) theme keyword
        Integer themeKeyword = ThemeKeywordMapping.getKeywordForTheme(theme);

        // 4) sort strategy
        String sortOption = PaceSortMapping.getSortForPace(pace);

        return new MovieQuery(genreIds, storyKeyword, themeKeyword, sortOption);
    }
}
