package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.GameConstants.DIVISION;

import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;


public final class PrimeGame {

    private PrimeGame() {
    }

    /**
     * Правило игры простое число.
     */
    private static final String ANSWER_PRIME =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    /**
     * Возврат правил.
     * @return правила
     */
    public static String getRules() {
        return ANSWER_PRIME;
    }

    /**
     * Генерация игры.
     * @return возврат вопросов и ответов в массиве
     */
    public static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = Engine.randomNumber();

            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = isPrime(number) ? "yes" : "no";
        }

        return rounds;
    }
        private static boolean isPrime(final int number) {
            return number <= 2 || (number % 2 == 1 && checkDivision(number));
        }

    private static boolean checkDivision(final int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = DIVISION; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
