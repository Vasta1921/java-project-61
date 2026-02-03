package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.println;

public class Cli {
    private static Scanner scan = new Scanner(System.in);
    public static String userName;
    /**
     * Статик метод для взаимодействия с пользователем.
     */
    public static void welcome() {
        println("Welcome to the Brain Games!");
        println("May I have your name?");
        userName = scan.nextLine();
        System.out.printf("Hello, %s!", userName);
    }

    private Cli() {
    }
}
