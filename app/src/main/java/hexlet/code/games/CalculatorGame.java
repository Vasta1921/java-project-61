package hexlet.code.games;

import hexlet.code.Cli;

import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.GameConstants.OPERATOR;
import static hexlet.code.Engine.randomOperator;
import static hexlet.code.Engine.userAnswer;
import static hexlet.code.Engine.isValidNumber;
import static hexlet.code.Engine.unCorrect;
import static hexlet.code.Engine.checkWin;
import static hexlet.code.Engine.TextConstants.RESULT_EXPRESSION;
import static hexlet.code.Engine.TextConstants.QUESTION_THREE_ARGUMENT;
import static hexlet.code.Engine.TextConstants.CORRECT;
import static hexlet.code.Engine.println;
import static hexlet.code.Engine.randomNumberForCalc;

public final class CalculatorGame {

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
            System.out.printf(
                    QUESTION_THREE_ARGUMENT, firstNumber, op, secondNumber);
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
