package service;

import model.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    private List<Question> questions;

    // Constructor — when you create this class, load the questions automatically
    public QuestionService() {
        this.questions = loadQuestions();
    }

    // This method creates and returns all the question objects
    private List<Question> loadQuestions() {
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question(
            "🌤️ What’s your current mood?",
            List.of("Motivated", "Relaxed", "Focused", "Adventurous")
        ));

        questionList.add(new Question(
            "📖 What kind of story do you want to experience?",
            List.of("Inspiring", "Weird", "Emotional", "Funny")
        ));

        questionList.add(new Question(
            "⏱️ Do you prefer something fast-paced or slow and deep?",
            List.of("Fast-paced", "Slow and emotional", "Balanced")
        ));

        questionList.add(new Question(
            "🎶 What type of background vibe do you enjoy?",
            List.of("Energetic", "Calm", "Hopeful", "Dark")
        ));

        questionList.add(new Question(
            "🧭 What’s your ideal theme for today’s adventure?",
            List.of("Future", "Fantasy", "Mystery", "Romance")
        ));

        return questionList;
    }

    // A method to get all questions (used by the UI)
    public List<Question> getQuestions() {
        return questions;
    }
}