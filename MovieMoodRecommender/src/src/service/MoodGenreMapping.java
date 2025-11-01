package service;

import java.util.List;
import java.util.Map;

public class MoodGenreMapping {

    private static final Map<String, List<Integer>> moodToGenres = Map.of(
        "Motivated", List.of(99, 80),               // Documentary / Crime
        "Relaxed", List.of(16, 35),                 // Animation / Comedy
        "Focused", List.of(12, 36, 10402),          // Adventure / History / Music
        "Adventurous", List.of(10402, 10751, 18)    // Music / Family / Drama
    );

    public static List<Integer> getGenresForMood(String mood) {
        return moodToGenres.getOrDefault(mood, List.of());
    }
}
