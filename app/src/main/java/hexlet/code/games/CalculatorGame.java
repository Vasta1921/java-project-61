package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import static hexlet.code.Engine.Constants.FINAL_SCORE;
import static hexlet.code.Engine.Constants.operator;

public class CalculatorGame {

    private CalculatorGame() {
    }

    /**
     * Игра калькулятор.
     */
    public static void playCalculatorGame() {
        Cli.welcome();
        processGame();
    }

    private static void processGame() {
        int score = 0;
        while (score < FINAL_SCORE) {

            System.out.println("What is the result of the expression?");
            int number1 = Engine.randomNumberForCalc();
            int number2 = Engine.randomNumberForCalc();
            char op = Engine.randomOperator(operator);
            int correctAnswer = switch (op) {
                case '+' -> number1 + number2;
                case '-' -> number1 - number2;
                case '*' -> number1 * number2;
                default -> 0;
            };
            System.out.printf("Question: %d %s %d \n", number1, op, number2);
            String answer = Engine.userAnswer();
            Engine.isValidNumber(answer);
            if (Integer.parseInt(answer) == correctAnswer) {
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
