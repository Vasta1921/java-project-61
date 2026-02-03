package hexlet.code.games;

import hexlet.code.Cli;
import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.TextConstants.NUMBER_MISSING;
import static hexlet.code.Engine.TextConstants.QUESTION;
import static hexlet.code.Engine.getArrayProgression;
import static hexlet.code.Engine.println;
import static hexlet.code.Engine.print;
import static hexlet.code.Engine.userAnswer;
import static hexlet.code.Engine.TextConstants.CORRECT;
import static hexlet.code.Engine.unCorrect;
import  static hexlet.code.Engine.checkWin;

public final class ProgressionGame {
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
            int lostIndex = ThreadLocalRandom.current()
                    .nextInt(arrayProgression.length);
            int correctAnswer = arrayProgression[lostIndex];
            print(QUESTION);
            for (int i = 0; i < arrayProgression.length; i++) {
                if (i == lostIndex) {
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
