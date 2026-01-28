package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class CalculatorGame {
    /**
     * Игра калькулятор.
     */
    public static void calcGame() {
        int score = 0;
        int finalScore = 3;
        char[] operator = {'+', '-', '*'};
        Cli.welcome();
        processGame(score, finalScore, operator);
    }

    private static void processGame(int score, int finalScore, char[] operator) {
        while (score < finalScore) {
            System.out.println("What is the result of the expression?");
            int number1 = Engine.randomNumber();
            int number2 = Engine.randomNumber();
            char op = Engine.randomOperator(operator);
            int correctAnswer = switch (op) {
                case '+' -> number1 + number2;
                case '-' -> number1 - number2;
                case '*' -> number1 * number2;
                default -> 0;
            };
            System.out.println("Question: " + number1 + " " + op + " " + number2);
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
        Engine.win(score, finalScore);
    }

    private CalculatorGame() {
    }
}
