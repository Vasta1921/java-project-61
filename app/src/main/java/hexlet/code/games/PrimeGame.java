package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import static hexlet.code.Engine.Constants.FINAL_SCORE;

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
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (score < FINAL_SCORE) {
            int number = Engine.randomNumber();
            System.out.println("Question: " + number);
            String answer = Engine.userAnswer();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Invalid answer.");
                break;
            }
            String correctAnswer = isPrime(number) ? "yes" : "no";
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

    private static boolean isPrime(int number) {
        if (number <= 2 || (number % 2 == 1 && checkDivision(number))) {
            return true;
        }
        return false;
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