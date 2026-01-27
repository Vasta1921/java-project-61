package hexlet.code;

import java.util.Scanner;

public class Cli {
    /**
     * Статик метод для взаимодействия с пользователем.
     */
    public static void welcome() {
        Scanner scan = new  Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scan.next();
        System.out.printf("Welcome, %s!", name);
    }
    private Cli() {
    }
}
