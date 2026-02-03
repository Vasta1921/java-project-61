package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.GameConstants.ARRAY_LENGTH_FROM;
import static hexlet.code.Engine.GameConstants.ARRAY_LENGTH_TO;
import static hexlet.code.Engine.GameConstants.FINAL_SCORE;
import static hexlet.code.Engine.GameConstants.NUMBER_FROM;
import static hexlet.code.Engine.GameConstants.NUMBER_TO;
import static hexlet.code.Engine.GameConstants.STEP_TO;

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
     */
    public static void unCorrect(final String answer,
                                 final String correctAnswer) {
        System.out.printf(
                "'%s' is wrong answer ;(. Correct answer was '%s'.%n"
                        + "Let's try again, %s!",
                answer,
                correctAnswer,
                Cli.getUserName()
        );
    }


    /**
     * Поздравление с победой.
     *
     * @param score счет игрока
     */
    public static void checkWin(final int score) {
        if (score == FINAL_SCORE) {
            System.out.printf("Congratulations, %s!", Cli.getUserName());
        }
    }

    /**
     * Рандомное число от -100 до 99.
     * @return int рандомное число.
     */
    public static int randomNumberForCalc() {
        return ThreadLocalRandom.current().nextInt(NUMBER_FROM, NUMBER_TO);
    }

    /**
     * Рандомное число от 1 до 99.
     * @return int рандомное число.
     */
    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt(1, NUMBER_TO);
    }

    /**
     * Рандомный оператор.
     *
     * @param operator массив операторов.
     * @return возврат рандомного опертора.
     */
    public static char randomOperator(final char[] operator) {
        return operator[ThreadLocalRandom.current().nextInt(0, 2)];
    }

    /**
     * Ответ пользователя.
     *
     * @return ответ
     */
    public static String userAnswer() {
        return SCANNER.nextLine();
    }

    /**
     * Проверка на валидное число.
     *
     * @param number ввод пользователя.
     */
    public static void isValidNumber(final String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            println("Please enter a valid number.");
        }
    }

    /**
     * Прогрессия чисел.
     *
     * @return прогрессия.
     */
    public static int[] getArrayProgression() {
        int firstNumber = ThreadLocalRandom.current().nextInt(1, NUMBER_TO);
        int step = ThreadLocalRandom.current().nextInt(2, STEP_TO);
        int lengthArray = ThreadLocalRandom.current()
                .nextInt(ARRAY_LENGTH_FROM, ARRAY_LENGTH_TO);
        int[] progression = new int[lengthArray];
        progression[0] = firstNumber;
        for (int i = 1; i < lengthArray; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }

    /**
     * Вывод в консоль.
     * @param message сообщение в консоль.
     */
    public static void println(final String message) {
        System.out.println(message);
    }
    /**
     * Вывод в консоль.
     * @param message сообщение в консоль.
     */
    public static void print(final String message) {
        System.out.print(message);
    }

    public static class GameConstants {
        /**
         * Константа финального счета.
         */
        public static final int FINAL_SCORE = 3;
        /**
         * Константа операторов.
         */
        public static final char[] OPERATOR = {'+', '-', '*'};
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
         * Константа для проверки деления.
         */
        public static final int DIVISION = 3;
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
         * Диапозон рандомного числа ОТ.
         */
        public static final int NUMBER_FROM = -100;
        /**
         * Диапозон рандомного числа ДО.
         */
        public static final int NUMBER_TO = 100;
        /**
         * Диапозон шага ДО.
         */
        public static final int STEP_TO = 11;
        /**
         * Диапозон длинны массива ОТ.
         */
        public static final int ARRAY_LENGTH_FROM = 5;
        /**
         * Диапозон длинны массива ДО.
         */
        public static final int ARRAY_LENGTH_TO = 11;
    }

    public static class TextConstants {
        /**
         * Вывод для игры калькулятор.
         */
        public static final String RESULT_EXPRESSION =
                "What is the result of the expression?";
        /**
         * Вывод для игры калькулятор, числа и оператор.
         */
        public static final String QUESTION_THREE_ARGUMENT =
                "Question: %d %s %d \n";
        /**
         * Вывод для правильного ответа.
         */
        public static final String CORRECT = "Correct!";
        /**
         * Вывод для игры четное/нечетное.
         */
        public static final String ANSWER_EVEN =
                "Answer 'yes' if the number is even, otherwise answer 'no'.!";
        /**
         * Переменная для сравнения результата.
         */
        public static final String YES = "yes";
        /**
         * Переменная для сравнения результата.
         */
        public static final String NO = "no";
        /**
         * Вопрос.
         */
        public static final String QUESTION = "Question: ";
        /**
         * Вывод если введено не корректный ответ.
         */
        public static final String INVALID_ANSWER = "Invalid answer.";
        /**
         * Вывод для игры простое число.
         */
        public static final String GREATEST_COMMON_DIVISOR =
                "Find the greatest common divisor of given numbers.";
        /**
         * Вопрос для игры простое число.
         */
        public static final String ANSWER_PRIME =
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        /**
         * Вывод для игры пропущенное число в прогрессии.
         */
        public static final String NUMBER_MISSING =
                "What number is missing in the progression?";

    }

}

