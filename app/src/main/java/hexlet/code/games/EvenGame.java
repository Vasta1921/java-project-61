package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;


public final class EvenGame {

    private EvenGame() {
    }

    /**
     * Правило игры четное.
     */
    private static final String ANSWER_EVEN =
            "Answer 'yes' if the number is even, otherwise answer 'no'.!";

    /**
     * Возврат правил.
     * @return правило.
     */
    public static String getRules() {
        return ANSWER_EVEN;
    }

    /**
     * Генерация игры.
     * @return вопросы и ответы.
     */
    public static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = Engine.randomNumber();

            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = isEven(number) ? "yes" : "no";
        }
        return rounds;
    }

    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }
}
