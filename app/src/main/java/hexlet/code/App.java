package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

import static hexlet.code.Engine.GameConstants.FIFTH_BUTTON;
import static hexlet.code.Engine.GameConstants.FIRST_BUTTON;
import static hexlet.code.Engine.GameConstants.FOURTH_BUTTON;
import static hexlet.code.Engine.GameConstants.SECOND_BUTTON;
import static hexlet.code.Engine.GameConstants.SIXTH_BUTTON;
import static hexlet.code.Engine.GameConstants.THIRD_BUTTON;
import static hexlet.code.Engine.GameConstants.ZERO_BUTTON;
import static hexlet.code.Engine.println;

public final class App {
    /**
     * Метод запускающий скрипт.
     *
     * @param args метод.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        println("Please enter the game number and press Enter.");
        println("""
                1 - Greet\s
                2 - Even\s
                3 - Calc\s
                4 - Gcd\s
                5 - Progression\s
                6 - Prime\s
                0 - Exit""");
        int choice = scan.nextInt();
        println("Your choice: " + choice);
        switch (choice) {
            case ZERO_BUTTON:
                System.exit(0);
                break;
            case FIRST_BUTTON:
                Cli.welcome();
                break;
            case SECOND_BUTTON:
                Engine.processGame(
                        EvenGame.getRules(),
                        EvenGame.getRounds());
                break;
            case THIRD_BUTTON:
                Engine.processGame(
                        CalculatorGame.getRules(),
                        CalculatorGame.getRounds());
                break;
            case FOURTH_BUTTON:
                Engine.processGame(
                        GcdGame.getRules(),
                        GcdGame.getRounds());
                break;
            case FIFTH_BUTTON:
                Engine.processGame(
                        ProgressionGame.getRules(),
                        ProgressionGame.getRounds());
                break;
            case SIXTH_BUTTON:
                Engine.processGame(
                        PrimeGame.getRules(),
                        PrimeGame.getRounds());
                break;
            default:
                println("Unknown option " + choice);
        }
    }

    private App() {
    }
}
