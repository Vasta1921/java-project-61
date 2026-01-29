package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.Constants.FINAL_SCORE;

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
        System.out.println("What number is missing in the progression?");
        while (score < FINAL_SCORE) {
            var prog = Engine.getArrayProgression();
            int lostIndex = ThreadLocalRandom.current().nextInt(0, prog.length + 1);
            int correctAnswer = 0;
            System.out.print("Question: ");
            for (int i = 0; i < prog.length; i++) {
                if (i == lostIndex) {
                    correctAnswer = prog[i];
                    System.out.print(".. ");
                } else {
                    System.out.print(prog[i] + " ");
                }
            }
            String answer = Engine.userAnswer();
            if (answer.equals(String.valueOf(correctAnswer))) {
                score++;
                System.out.println("Correct!");
            } else {
                Engine.unCorrect(answer, String.valueOf(correctAnswer));
                break;
            }
        }
        Engine.checkWin(score);
    }
}
