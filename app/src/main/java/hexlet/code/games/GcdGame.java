package hexlet.code.games;

import hexlet.code.Cli;

import static hexlet.code.Engine.*;
import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.TextConstants.*;

public class GcdGame {

    private GcdGame() {
    }
    /**
     * Игра НОД.
     */
    public static void gcdGame() {
        Cli.welcome();
        processGame();
    }
    private static void processGame() {
        int score = 0;
        println(GREATEST_COMMON_DIVISOR);
        while (score < FINAL_SCORE) {
            int firstNumber = randomNumber();
            int secondNumber = randomNumber();
            int temp = secondNumber;
            int correctAnswer = 0;
            println(QUESTION + firstNumber + " " + secondNumber);
            String answer = userAnswer();
            isValidNumber(answer);
            while (secondNumber != 0) {
                secondNumber = firstNumber % secondNumber;
                firstNumber = temp;
                temp = secondNumber;
            }
            correctAnswer = firstNumber;
            if (answer.equals(String.valueOf(correctAnswer))) {
                score++;
                println(CORRECT);
            } else {
                unCorrect(answer, String.valueOf(correctAnswer));
                break;
            }
        }
        checkWin(score);
    }
}
