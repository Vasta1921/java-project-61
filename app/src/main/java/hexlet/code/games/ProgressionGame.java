package hexlet.code.games;

import hexlet.code.Cli;

import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.*;
import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.TextConstants.*;

public class ProgressionGame {
    private ProgressionGame() {
    }

    /**
     * Игра прогрессия.
     */
    public static void progressionGame() {
        Cli.welcome();
        processGame();
    }
    private static void processGame() {
        int score = 0;
        println(NUMBER_MISSING);
        while (score < FINAL_SCORE) {
            var arrayProgression = getArrayProgression();
            int lostIndex = ThreadLocalRandom.current().nextInt(0, arrayProgression.length + 1);
            int correctAnswer = 0;
            print(QUESTION);
            for (int i = 0; i < arrayProgression.length; i++) {
                if (i == lostIndex) {
                    correctAnswer = arrayProgression[i];
                    print(".. ");
                } else {
                    print(arrayProgression[i] + " ");
                }
            }
            String answer = userAnswer();
            if (answer.equals(String.valueOf(correctAnswer))) {
                score++;
                println(CORRECT);
            } else {
                unCorrect(answer, String.valueOf(correctAnswer));
                break;
            }
        }
        checkWin(score);
    }
}
