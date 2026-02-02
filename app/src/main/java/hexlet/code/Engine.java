package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.GameConstants.FINAL_SCORE;

public class Engine {

    /**
     * Ввод команд пользователя.
     */
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Валидация неправильного ответа.
     *
     * @param answer        ответ пользователя.
     * @param correctAnswer правильный ответ.
     */
    public static void unCorrect(String answer, String correctAnswer) {
        println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'.\nLet's try again");
    }

    /**
     * Поздравление с победой.
     * @param score счет игрока
     */
    public static void checkWin(int score) {
        if (score == FINAL_SCORE) {
            println("Congratulations!");
        }
    }

    /**
     * Рандомное число от -100 до 99.
     */
    public static int randomNumberForCalc() {
        return ThreadLocalRandom.current().nextInt(-100, 100);
    }

    /**
     * Рандомное число от 1 до 99.
     */
    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }

    /**
     * Рандомный оператор.
     *
     * @param operator массив операторов.
     * @return возврат рандомного опертора.
     */
    public static char randomOperator(char[] operator) {
        return operator[ThreadLocalRandom.current().nextInt(0, 2)];
    }

    /**
     * Ответ пользователя.
     *
     * @return ответ
     */
    public static String userAnswer() {
        return scan.nextLine();
    }

    /**
     * Проверка на валидное число.
     *
     * @param number ввод пользователя.
     */
    public static void isValidNumber(String number) {
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
        int firstNumber = ThreadLocalRandom.current().nextInt(1, 100);
        int step = ThreadLocalRandom.current().nextInt(2, 10);
        int lengthArray = ThreadLocalRandom.current().nextInt(5, 11);
        int[] progression = new int[lengthArray];
        progression[0] = firstNumber;
        for (int i = 1; i < lengthArray; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
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
    }

    public static class TextConstants {
        public static final String RESULT_EXPRESSION = "What is the result of the expression?";
        public static final String QUESTION_THREE_ARGUMENT = "Question: %d %s %d \n";
        public static final String CORRECT = "Correct!";
        public static final String ANSWER_EVEN = "Answer 'yes' if the number is even, otherwise answer 'no'.!";
        public static final String YES = "yes";
        public static final String NO = "no";
        public static final String QUESTION = "Question: ";
        public static final String INVALID_ANSWER = "Invalid answer.";
        public static final String GREATEST_COMMON_DIVISOR = "Find the greatest common divisor of given numbers.";
        public static final String ANSWER_PRIME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        public static final String NUMBER_MISSING = "What number is missing in the progression?";

    }

}

