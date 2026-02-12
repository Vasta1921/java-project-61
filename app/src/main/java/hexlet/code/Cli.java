package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private Cli() {
    }
    /**
     * Сканнер.
     */
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * Статик метод для взаимодействия с пользователем.
     */
    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = SCANNER.nextLine();
        System.out.printf("Hello, %s!", userName);
    }
}
