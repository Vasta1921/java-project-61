package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.ROUNDS_COUNT;


public final class ProgressionGame {
    private ProgressionGame() {
    }
    /**
     * Диапозон рандомного числа ДО.
     */
    private static final int NUMBER_TO = 100;
    /**
     * Правило игры прогрессии.
     */
    private static final String NUMBER_MISSING =
            "What number is missing in the progression?";
    /**
     * Диапозон шага ДО.
     */
    private static final int STEP_TO = 11;
    /**
     * Диапозон длинны массива ОТ.
     */
    private static final int ARRAY_LENGTH_FROM = 5;
    /**
     * Диапозон длинны массива ДО.
     */
    private static final int ARRAY_LENGTH_TO = 11;

    /**
     * Возврат правил.
     * @return правила.
     */
    private static String getRules() {
        return NUMBER_MISSING;
    }

    /**
     * Генерация прорессии.
     * @param firstNumber первое число прогресии
     * @param step шаг прогресии
     * @param length длинна прогресии
     * @return прогрессия
     */
    private static String[] generateProgression(final int firstNumber,
                                                final int step,
                                                final int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(firstNumber + i * step);
        }
        return progression;
    }
    /**
     * Генерация раундов.
     * @return массив раунда и правильного ответа
     */
    private static String[] generateRound() {
        int firstNumber = ThreadLocalRandom.current().nextInt(1, NUMBER_TO);
        int step = ThreadLocalRandom.current().nextInt(2, STEP_TO);
        int lengthArray = ThreadLocalRandom.current().
                nextInt(ARRAY_LENGTH_FROM, ARRAY_LENGTH_TO);
        String[] progression =
                generateProgression(firstNumber, step, lengthArray);
        int hiddenIndex = Utils.randomNumber(1, lengthArray);
        int correctAnswer = firstNumber + hiddenIndex * step;
        progression[hiddenIndex] = "..";
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
