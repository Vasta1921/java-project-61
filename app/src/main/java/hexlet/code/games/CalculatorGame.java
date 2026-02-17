package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_COUNT;

public final class CalculatorGame {
    private CalculatorGame() {
    }
    /**
     * Диапозон рандомного числа ОТ.
     */
    private static final int NUMBER_FROM = -100;
    /**
     * Диапозон рандомного числа ДО.
     */
    private static final int NUMBER_TO = 100;
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
     * Рандомный оператор.
     * @return возврат рандомного опертора.
     */
    private static char randomOperator() {
        return CalculatorGame.OPERATORS[Utils.randomNumber(0, 2)];
    }
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

            int a = Utils.randomNumber(NUMBER_FROM, NUMBER_TO);
            int b = Utils.randomNumber(NUMBER_FROM, NUMBER_TO);
            char op = randomOperator();

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
