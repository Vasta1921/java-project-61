package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;

public final class CalculatorGame {
    private CalculatorGame() {
    }
    /**
     * Правила игры.
     */
    private static final String RESULT_EXPRESSION =
            "What is the result of the expression?";
    /**
     * Массив операторов.
     */
    private static final char[] OPERATORS = {'+', '-', '*'};
    /**
     * Получение правила игры.
     * @return правила.
     */
    private static String getRules() {
        return RESULT_EXPRESSION;
    }
    /**
     * Раунды игры.
     * @return массив раундов.
     */
    private static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {

            int a = Utils.randomNumberForCalc();
            int b = Utils.randomNumberForCalc();
            char op = Engine.randomOperator(OPERATORS);

            int correctAnswer = calculate(a, b, op);

            rounds[i][0] = a + " " + op + " " + b;
            rounds[i][1] = String.valueOf(correctAnswer);
        }
        return rounds;
    }
    private static int calculate(final int a, final int b, final char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default ->
                    throw new IllegalStateException("Unknown operator: " + op);
        };
    }
    /**
     * Метод запускаюший игру.
     */
    public static void playGame() {
        String rules = getRules();
        String[][] rounds = getRounds();
        Engine.processGame(rules, rounds);
    }
}
