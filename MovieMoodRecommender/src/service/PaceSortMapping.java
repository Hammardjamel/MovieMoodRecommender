package service;

import java.util.Map;

public class PaceSortMapping {

    private static final Map<String, String> paceToSort = Map.of(
        "Fast-paced", "popularity.desc",
        "Slow and emotional", "vote_average.desc",
        "Balanced", "release_date.desc"
    );

    public static String getSortForPace(String pace) {
        return paceToSort.getOrDefault(pace, "popularity.desc");
    }
}
