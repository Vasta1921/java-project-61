package hexlet.code.games;

import hexlet.code.Cli;

import static hexlet.code.Engine.*;
import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.TextConstants.*;

public class PrimeGame {

    private PrimeGame() {
    }
    /**
     * Игра простое число или нет.
     */
    public static void primeGame() {
        Cli.welcome();
        processGame();
    }

    private static void processGame() {
        int score = 0;
        println(ANSWER_PRIME);
        while (score < FINAL_SCORE) {
            int number = randomNumber();
            println(QUESTION + number);
            String answer = userAnswer();
            if (!answer.equals(YES) && !answer.equals(NO)) {
                println(INVALID_ANSWER);
                break;
            }
            String correctAnswer = isPrime(number) ? YES : NO;
            if (answer.equals(correctAnswer)) {
                score++;
                println(CORRECT);
            } else {
                unCorrect(answer, correctAnswer);
                break;
            }
        }
        checkWin(score);
    }

    private static boolean isPrime(int number) {
        return number <= 2 || (number % 2 == 1 && checkDivision(number));
    }

    private static boolean checkDivision(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}