package ui;

import model.Question;
import service.QuestionService;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private QuestionService questionService;
    private Scanner scanner;

    public ConsoleUI() {
        questionService = new QuestionService();
        scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        System.out.println("\n==============================================");
        System.out.println("✨  🎬 Welcome to Movie Mood Recommender 🎧  ✨");
        System.out.println("==============================================\n");
        List<Question> questions = questionService.getQuestions();

        for (Question question : questions) {
            System.out.println(question.getText());

            List<String> choices = question.getOptions();
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ". " + choices.get(i));
            }

            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();
            System.out.println("You selected: " + choices.get(userChoice - 1) + "\n");
        }

        System.out.println("=== Thank you for completing the quiz! ===");
    }
}