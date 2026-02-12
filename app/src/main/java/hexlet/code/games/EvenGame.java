package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

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
    private static String getRules() {
        return ANSWER_EVEN;
    }

    /**
     * Генерация игры.
     * @return вопросы и ответы.
     */
    private static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = Utils.randomNumber();

            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = isEven(number) ? "yes" : "no";
        }
        return rounds;
    }

    private static boolean isEven(final int number) {
        return number % 2 == 0;
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
