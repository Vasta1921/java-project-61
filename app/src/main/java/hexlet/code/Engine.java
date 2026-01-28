package hexlet.code;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {
    /**
     * Ввод команд пользователя.
     */
    Scanner scan = new Scanner(System.in);

    /**
     * Валидация неправильного ответа.
     *
     * @param answer        ответ пользователя.
     * @param correctAnswer правильный ответ.
     */
    public static void unCorrect(String answer, String correctAnswer) {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'.\nLet's try again");
    }

    /**
     * Поздравление с победой.
     *
     * @param score      счет игрока
     * @param finalScore счет для победы игрока
     */
    public static void win(int score, int finalScore) {
        if (score == finalScore) {
            System.out.println("Congratulations!");
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
        Scanner scan = new Scanner(System.in);
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
            System.out.println("Please enter a valid number.");
        }
    }

    /**
     * Увелечение очков.
     * @param score         очки пользователя.
     * @param answer        ответ пользователя
     * @param correctAnswer верный ответ
     */
    public static void increaseScore(int score, String answer, int correctAnswer) {
        if (answer.equals(String.valueOf(correctAnswer))) {
            score++;
            System.out.println("Correct!");
        }
    }

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
}

