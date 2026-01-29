package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import static hexlet.code.Engine.Constants.FINAL_SCORE;

public class GcdGame {

    private GcdGame() {
    }
    /**
     * Игра НОД.
     */
    public static void gcdGame() {
        Cli.welcome();
        proccesGame();
    }
    private static void proccesGame() {
        int score = 0;
        System.out.println("Find the greatest common divisor of given numbers.");
        while (score < FINAL_SCORE) {
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
        Engine.checkWin(score);
    }
}
