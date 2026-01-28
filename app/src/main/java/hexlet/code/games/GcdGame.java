package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class GcdGame {
    /**
     * Игра НОД.
     */
    public static void gcdGame() {
        int finalScore = 3;
        int score = 0;
        Cli.welcome();
        proccesGame(score, finalScore);
    }
    private static void proccesGame(int score, int finalScore) {
        System.out.println("Find the greatest common divisor of given numbers.");
        while (score < finalScore) {
            int number1 = Engine.randomNumber();
            int number2 = Engine.randomNumber();
            int temp = number2;
            int correctAnswer = 0;
            System.out.println("Question:" + number1 + " " + number2);
            String answer = Engine.userAnswer();
            Engine.isValidNumber(answer);
            while (number2 != 0) {
                number2 = number1 % number2;
                number1 = temp;
                temp = number2;
            }
            correctAnswer = number1;
            if (answer.equals(String.valueOf(correctAnswer))) {
                score++;
                System.out.println("Correct!");
            } else {
                Engine.unCorrect(answer, String.valueOf(correctAnswer));
                break;
            }
        }
        Engine.win(score, finalScore);
    }
    private GcdGame() {
    }
}
