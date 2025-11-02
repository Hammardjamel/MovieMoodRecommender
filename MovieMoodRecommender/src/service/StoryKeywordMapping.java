package service;

import java.util.Map;

public class StoryKeywordMapping {

    private static final Map<String, Integer> storyToKeyword = Map.of(
        "Inspiring", 188471,
        "Weird", 180467,
        "Emotional", 242929,
        "Funny", 9672
    );

    public static Integer getKeywordForStory(String storyType) {
        return storyToKeyword.getOrDefault(storyType, null);
    }
}
