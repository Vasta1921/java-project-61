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
     * Имя пользователя.
     */
    private static String userName;
    /**
     * Геттер для имени.
     * @return имя юзера
     */
    public static String getUserName() {
        return userName;
    }
    /**
     * Статик метод для взаимодействия с пользователем.
     */
    public static void welcome() {
        println("Welcome to the Brain Games!");
        println("May I have your name?");
        userName = SCANNER.nextLine();
        System.out.printf("Hello, %s!", userName);
    }
}
