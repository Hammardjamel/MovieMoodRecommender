package ui;

import model.Question;
import service.QuestionService;
import service.ResponseParser;
import service.APIClient;
import service.MovieQueryBuilder;
import service.TMDBUrlBuilder;
import model.Movie;
import model.MovieQuery;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private QuestionService questionService;
    private Scanner scanner;

    private String mood;
    private String storyType;
    private String pace;
    private String theme;

    public ConsoleUI() {
        questionService = new QuestionService();
        scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        System.out.println("\n==============================================");
        System.out.println("✨  🎬 Welcome to Movie Mood Recommender 🎧  ✨");
        System.out.println("==============================================\n");

        List<Question> questions = questionService.getQuestions();

        int index = 0;
        for (Question question : questions) {
            System.out.println(question.getText());

            List<String> choices = question.getOptions();
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ". " + choices.get(i));
            }

            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();
            String selected = choices.get(userChoice - 1);

            if (index == 0) mood = selected;
            else if (index == 1) storyType = selected;
            else if (index == 2) pace = selected;
            else if (index == 3) theme = selected;

            System.out.println("You selected: " + selected + "\n");
            index++;
        }

        System.out.println("=== Thank you for completing the quiz! ===");

        // BUILD QUERY MODEL from user answers
        MovieQuery query = new MovieQueryBuilder()
                .setMood(mood)
                .setStoryType(storyType)
                .setPace(pace)
                .setTheme(theme)
                .build();

        // Build final URL
        String url = TMDBUrlBuilder.buildDiscoverUrl(query);

        System.out.println("\nGenerated URL:");
        System.out.println(url);

        // Test if we resived the json file 
        String json = APIClient.fetch(url);
        System.out.println("\nRAW JSON response preview:");
        System.out.println(json.substring(0, 300)); // just preview first 300 chars

        //now we should see just the top 3 
        //String json = APIClient.fetch(url);

        List<Movie> movies = ResponseParser.parseMovies(json);

        System.out.println("\nTop 3 Movies:");
        for (int i = 0; i < Math.min(3, movies.size()); i++) {
            System.out.println("\n" + movies.get(i).toString());
        }
    }
}