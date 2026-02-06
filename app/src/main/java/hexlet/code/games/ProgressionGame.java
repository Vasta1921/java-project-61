package hexlet.code.games;

import hexlet.code.Engine;
import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;

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
     * @return правила.
     */
    public static String getRules() {
        return NUMBER_MISSING;
    }

    /**
     * Генерация раундов.
     * @return массив раунда и правильного ответа
     */
    public static String[][] getRounds() {
        String[][] rounds = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int[] progression = Engine.getArrayProgression();
            int hiddenIndex = ThreadLocalRandom.current()
                    .nextInt(progression.length);

            int correctAnswer = progression[hiddenIndex];

            rounds[i][0] = buildQuestion(progression, hiddenIndex);
            rounds[i][1] = String.valueOf(correctAnswer);
        }

        return rounds;
    }
    private static String buildQuestion(final int[] progression,
                                        final int hiddenIndex) {
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(progression[i]).append(" ");
            }
        }

        return question.toString().trim();
    }
}
