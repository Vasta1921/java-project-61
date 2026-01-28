package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class PrimeGame {
    /**
     * Игра простое число или нет.
     */
    public static void primeGame() {
        int finalScore = 3;
        int score = 0;
        Cli.welcome();
        processGame(score, finalScore);
    }

    private static void processGame(int score, int finalScore) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (score < finalScore) {
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
        Engine.win(score, finalScore);
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