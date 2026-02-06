package hexlet.code;


import java.util.Scanner;

import static hexlet.code.Engine.println;

public final class Cli {
    private Cli() {
    }
    /**
     * Сканнер.
     */
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * Статик метод для взаимодействия с пользователем.
     * @return имя пользователя
     */
    public static String welcome() {
        println("Welcome to the Brain Games!");
        println("May I have your name?");
        String userName = SCANNER.nextLine();
        System.out.printf("Hello, %s!", userName);
        return userName;
    }
}
