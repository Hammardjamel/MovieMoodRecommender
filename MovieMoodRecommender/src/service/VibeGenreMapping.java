package service;

import java.util.Map;

public class VibeGenreMapping {

    private static final Map<String, Integer> vibeToGenre = Map.of(
        "Energetic", 28,   // Action
        "Calm", 35,        // Comedy
        "Hopeful", 18,     // Drama
        "Dark", 53         // Thriller
    );

    public static Integer getGenreForVibe(String vibe) {
        return vibeToGenre.getOrDefault(vibe, null);
    }
}