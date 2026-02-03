package hexlet.code.games;

import hexlet.code.Cli;

import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.TextConstants.ANSWER_EVEN;
import static hexlet.code.Engine.TextConstants.INVALID_ANSWER;
import static hexlet.code.Engine.TextConstants.NO;
import static hexlet.code.Engine.userAnswer;
import static hexlet.code.Engine.TextConstants.QUESTION;
import static hexlet.code.Engine.unCorrect;
import static hexlet.code.Engine.checkWin;
import static hexlet.code.Engine.TextConstants.YES;
import static hexlet.code.Engine.TextConstants.CORRECT;
import static hexlet.code.Engine.println;
import static hexlet.code.Engine.randomNumber;

public final class EvenGame {

    private EvenGame() {
    }
    /**
     * Четное или нет игра.
     */
    public static void evenOrNot() {
        Cli.welcome();
        processGame();
    }
    private static void processGame() {
        int score = 0;
        while (score < FINAL_SCORE) {
            println(ANSWER_EVEN);
            int number = randomNumber();
            println(QUESTION + number);
            String answer = userAnswer();
            if (!answer.equalsIgnoreCase(YES) && !answer.equalsIgnoreCase(NO)) {
                println(INVALID_ANSWER);
                break;
            }
            String correctAnswer = isEven(number) ? YES : NO;
            if (answer.equals(correctAnswer)) {
                score++;
                println(CORRECT);
            } else {
                unCorrect(answer, correctAnswer);
                break;
            }
        }
        checkWin(score);
    }
    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }
}
