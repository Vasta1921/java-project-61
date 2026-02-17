package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_COUNT;

public final class GcdGame {
    private GcdGame() {
    }
    /**
     * Диапозон рандомного числа ОТ.
     */
    private static final int NUMBER_FROM = 1;
    /**
     * Диапозон рандомного числа ДО.
     */
    private static final int NUMBER_TO = 100;
    /**
     * Правило игры миниальный делитель.
     */
    private static final String GREATEST_COMMON_DIVISOR =
            "Find the greatest common divisor of given numbers.";

    /**
     * Возврат правил.
     * @return правило
     */
    private static String getRules() {
        return  GREATEST_COMMON_DIVISOR;
    }

    /**
     * Генерация игры.
     * @return вопросы и ответы.
     */
    private static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int firstNumber = Utils.randomNumber(NUMBER_FROM, NUMBER_TO);
            int secondNumber = Utils.randomNumber(NUMBER_FROM, NUMBER_TO);

            int gcd = calculateGcd(firstNumber, secondNumber);

            rounds[i][0] = firstNumber + " " + secondNumber;
            rounds[i][1] = String.valueOf(gcd);
        }

        return rounds;
    }
    @SuppressWarnings("checkstyle:FinalParameters")
    private static int calculateGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Запуск игры.
     */
    public static void playGame() {
        String rules = getRules();
        String[][] rounds = getRounds();
        Engine.processGame(rules, rounds);
    }
}
