package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import java.util.Scanner;

public final class App {
    private App() {
    }
    /**
     * Нулевая кнопка.
     */
    public static final int ZERO_BUTTON = 0;
    /**
     * Первая кнопка.
     */
    public static final int FIRST_BUTTON = 1;
    /**
     * Вторая кнопка.
     */
    public static final int SECOND_BUTTON = 2;
    /**
     * Третья кнопка.
     */
    public static final int THIRD_BUTTON = 3;
    /**
     * Четвёртая кнокпка.
     */
    public static final int FOURTH_BUTTON = 4;
    /**
     * Пятая кнопка.
     */
    public static final int FIFTH_BUTTON = 5;
    /**
     * Шестая кнопка.
     */
    public static final int SIXTH_BUTTON = 6;
    /**
     * Метод запускающий скрипт.
     * @param args метод.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                1 - Greet\s
                2 - Even\s
                3 - Calc\s
                4 - Gcd\s
                5 - Progression\s
                6 - Prime\s
                0 - Exit""");
        int choice = scan.nextInt();
        System.out.println("Your choice: " + choice);
        switch (choice) {
            case ZERO_BUTTON:
                System.exit(0);
                break;
            case FIRST_BUTTON:
                Cli.welcome();
                break;
            case SECOND_BUTTON:
                EvenGame.playGame();
                break;
            case THIRD_BUTTON:
                CalculatorGame.playGame();
                break;
            case FOURTH_BUTTON:
                GcdGame.playGame();
                break;
            case FIFTH_BUTTON:
                ProgressionGame.playGame();
                break;
            case SIXTH_BUTTON:
                PrimeGame.playGame();
                break;
            default:
                System.out.println("Unknown option " + choice);
        }
    }
}
