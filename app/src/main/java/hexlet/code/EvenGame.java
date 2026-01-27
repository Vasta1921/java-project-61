package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class EvenGame {

    /**
     * Четное или нет игра.
     */
    private static int score = 0;

    public static void evenOrNot() {
        int finalScore = 3;
        int score = 0;
        Scanner scan = new Scanner(System.in);
        Cli.welcome();
        while (score < finalScore) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            int number = ThreadLocalRandom.current().nextInt(1, 100);
            System.out.println("Question: " + number);
            String answer = scan.next();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Invalid answer.");
                break;
            }
            String correctAnswer = isEven(number) ? "yes" : "no";
            if (answer.equals(correctAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                        + "'.\nLet's try again");
                break;
            }
        }
        if (score == finalScore) {
            System.out.println("Congratulations!");
        }
    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
