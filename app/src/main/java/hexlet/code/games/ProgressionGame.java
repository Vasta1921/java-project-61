package hexlet.code.games;

import hexlet.code.Engine;

import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.GameConstants.ARRAY_LENGTH_FROM;
import static hexlet.code.Engine.GameConstants.ARRAY_LENGTH_TO;
import static hexlet.code.Engine.GameConstants.NUMBER_TO;
import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;
import static hexlet.code.Engine.GameConstants.STEP_TO;

public final class ProgressionGame {
    private ProgressionGame() {
    }

    /**
     * Правило игры прогрессии.
     */
    private static final String NUMBER_MISSING =
            "What number is missing in the progression?";

    /**
     * Возврат правил.
     *
     * @return правила.
     */
    private static String getRules() {
        return NUMBER_MISSING;
    }
    /**
     * Генерация раундов.
     *
     * @return массив раунда и правильного ответа
     */
    private static String[] generateRound() {
        int firstNumber = ThreadLocalRandom.current().nextInt(1, NUMBER_TO);
        int step = ThreadLocalRandom.current().nextInt(2, STEP_TO);
        int lengthArray = ThreadLocalRandom.current()
                .nextInt(ARRAY_LENGTH_FROM, ARRAY_LENGTH_TO);
        String[] progression = new String[lengthArray];
        int hiddenIndex = ThreadLocalRandom.current().nextInt(0, lengthArray);
        int correctAnswer = firstNumber + hiddenIndex * step;
        for (int i = 0; i < lengthArray; i++) {
            int value = firstNumber + i * step;
            progression[i] = (i == hiddenIndex) ? ".." : String.valueOf(value);
        }
        return new String[]{
                String.join(" ", progression),
                String.valueOf(correctAnswer)
        };
    }
    private static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            rounds[i] = generateRound();
        }
        return rounds;
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
