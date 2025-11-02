package service;

import java.util.Map;

public class ThemeKeywordMapping {

    private static final Map<String, Integer> themeToKeyword = Map.of(
        "Future", 10411,       // futuristic
        "Fantasy", 15836,      // magic
        "Mystery", 9673,       // investigation
        "Romance", 210024      // love story
    );

    public static Integer getKeywordForTheme(String theme) {
        return themeToKeyword.getOrDefault(theme, null);
    }
}