package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class EvenGame {

    /**
     * Четное или нет игра.
     */
    private static int score = 0;

    public static void evenOrNot() {
        boolean correct = true;
        int finalScore = 3;
        Scanner scan = new Scanner(System.in);
        Cli.welcome();
        while (score < finalScore) {
            if (!correct) {
                break;
            }
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            int number = ThreadLocalRandom.current().nextInt(1, 100);
            System.out.println("Question: " + number);
            String answer = scan.next();
            if (isEven(number) && answer.equals("yes")) {
                score++;
                System.out.println("Correct!");
            }
            if (isEven(number) && answer.equals("no")) {
                correct = false;
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.\n" + " Let's try again");
            }
            if (!isEven(number) && answer.equals("yes")) {
                correct = false;
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\n" + " Let's try again");
            }
            if (!isEven(number) && answer.equals("no")) {
                score++;
                System.out.println("Correct!");
            } else if (!answer.equals("yes") && !answer.equals("no")) {
                correct = false;
                System.out.println("Invalid answer.");
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
