package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.concurrent.ThreadLocalRandom;

public class ProgressionGame {
    /**
     * Игра прогрессия.
     */
    public static void progressionGame() {
        int finalScore = 3;
        int score = 0;
        Cli.welcome();
        processGame(score, finalScore);
    }

    private static void processGame(int score, int finalScore) {
        System.out.println("What number is missing in the progression?");
        while (score < finalScore) {
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
