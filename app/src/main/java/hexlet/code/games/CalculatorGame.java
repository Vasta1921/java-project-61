package hexlet.code.games;

import hexlet.code.Cli;

import static hexlet.code.Engine.*;
import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.GameConstants.OPERATOR;
import static hexlet.code.Engine.TextConstants.*;
import static hexlet.code.Engine.println;

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
            println(RESULT_EXPRESSION);
            int firstNumber = randomNumberForCalc();
            int secondNumber = randomNumberForCalc();
            char op = randomOperator(OPERATOR);
            int correctAnswer = switch (op) {
                case '+' -> firstNumber + secondNumber;
                case '-' -> firstNumber - secondNumber;
                case '*' -> firstNumber * secondNumber;
                default -> 0;
            };
            System.out.printf(QUESTION_THREE_ARGUMENT, firstNumber, op, secondNumber);
            String answer = userAnswer();
            isValidNumber(answer);
            if (Integer.parseInt(answer) == correctAnswer) {
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
