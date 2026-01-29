package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class EvenGame {
    /**
     * Четное или нет игра.
     */
    public static void evenOrNot() {
        int finalScore = 3;
        int score = 0;
        Cli.welcome();
        processGame(score, finalScore);
    }
    private static void processGame(int score, int finalScore) {
        while (score < finalScore) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            int number = Engine.randomNumber();
            System.out.println("Question: " + number);
            String answer = Engine.userAnswer();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Invalid answer.");
                break;
            }
            String correctAnswer = isEven(number) ? "yes" : "no";
            if (answer.equals(correctAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                Engine.unCorrect(answer, correctAnswer);
                break;
            }
        }
        Engine.checkWin(score);
    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
    private EvenGame() {
    }
}
