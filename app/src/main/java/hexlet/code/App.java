package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {
    /**
     * Метод запускающий скрипт
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                1 - Greet\s
                2 - Even\s
                3 - Calc\s
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
                CalculatorGame.calcGame();
                break;
            default:
                System.out.println("Unknown option");
        }
    }
}
