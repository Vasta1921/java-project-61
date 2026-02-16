package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.GameConstants.ROUNDS_COUNT;

public final class Engine {
    private Engine() {
    }

    /**
     * Ввод команд пользователя.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Валидация неправильного ответа.
     *
     * @param answer        ответ пользователя.
     * @param correctAnswer правильный ответ.
     * @param userName      имя пользователя
     */
    public static void unCorrect(final String answer,
                                 final String correctAnswer,
                                 final String userName) {
        System.out.printf(
                "'%s' is wrong answer ;(. Correct answer was '%s'.%n"
                        + "Let's try again, %s!",
                answer,
                correctAnswer,
                userName
        );
    }
    /**
     * Ответ пользователя.
     * @return ответ
     */
    public static String userAnswer() {
        return SCANNER.nextLine();
    }
    public static class GameConstants {
        /**
         * Колличество раундов.
         */
        public static final int ROUNDS_COUNT = 3;
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
    }
    /**
     * Запуск игры.
     * @param rules правила заданной игры
     * @param rounds распечатка раундов заданной игры
     */
    public static void processGame(final String rules,
                                   final String[][] rounds) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = SCANNER.nextLine();
        System.out.printf("Hello, %s!", userName);
        System.out.println(rules);
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String question = rounds[i][0];
            String correctAnswer = rounds[i][1];

            System.out.println("Question: " + question);
            String userAnswer = userAnswer();

            if (!userAnswer.equals(correctAnswer)) {
                unCorrect(userAnswer, correctAnswer, userName);
                return;
            }
            System.out.println("Correct!");
        }
        System.out.printf("Congratulations, %s!", userName);
    }
}


