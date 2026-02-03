package hexlet.code.games;

import hexlet.code.Cli;

import static hexlet.code.Engine.GameConstants.DIVISION;
import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.TextConstants.ANSWER_PRIME;
import static hexlet.code.Engine.TextConstants.CORRECT;
import static hexlet.code.Engine.TextConstants.INVALID_ANSWER;
import static hexlet.code.Engine.TextConstants.NO;
import static hexlet.code.Engine.TextConstants.QUESTION;
import static hexlet.code.Engine.TextConstants.YES;
import static hexlet.code.Engine.checkWin;
import static hexlet.code.Engine.println;
import static hexlet.code.Engine.randomNumber;
import static hexlet.code.Engine.unCorrect;
import static hexlet.code.Engine.userAnswer;

public final class PrimeGame {

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

    private static boolean isPrime(final int number) {
        return number <= 2 || (number % 2 == 1 && checkDivision(number));
    }

    private static boolean checkDivision(final int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = DIVISION; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
