package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    /**
     * Метод запускающий скрипт.
     */
    public static void main(String[] args) {
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
            case 0:
                System.exit(0);
                break;
            case 1:
                Cli.welcome();
                break;
            case 2:
                EvenGame.evenOrNot();
                break;
            case 3:
                CalculatorGame.playCalculatorGame();
                break;
            case 4:
                GcdGame.gcdGame();
                break;
            case 5:
                ProgressionGame.progressionGame();
                break;
            case 6:
                PrimeGame.primeGame();
                break;
            default:
                System.out.println("Unknown option");
        }
    }
    private App() {
    }
}
