package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;



public final class GcdGame {

    private GcdGame() {
    }

    /**
     * Правило игры миниальный делитель.
     */
    private static final String GREATEST_COMMON_DIVISOR =
            "Find the greatest common divisor of given numbers.";

    /**
     * Возврат правил.
     * @return правило
     */
    public static String getRules() {
        return  GREATEST_COMMON_DIVISOR;
    }

    /**
     * Генерация игры.
     * @return вопросы и ответы.
     */
    public static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int firstNumber = Engine.randomNumber();
            int secondNumber = Engine.randomNumber();

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
}
