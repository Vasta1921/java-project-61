package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.println;

public class Cli {
    /**
     * Статик метод для взаимодействия с пользователем.
     */
    public static void welcome() {
        Scanner scan = new  Scanner(System.in);
        println("Welcome to the Brain Games!");
        println("May I have your name?");
        String name = scan.next();
        System.out.printf("Hello, %s!", name);
    }
    private Cli() {
    }
}
