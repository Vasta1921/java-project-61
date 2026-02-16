package hexlet.code;

import java.util.concurrent.ThreadLocalRandom;

public final class Utils {
    private Utils() {
    }
    /**
     * Диапозон рандомного числа ОТ.
     */
    public static final int NUMBER_FROM = -100;
    /**
     * Диапозон рандомного числа ДО.
     */
    public static final int NUMBER_TO = 100;
    /**
     * Рандомное число от -100 до 99.
     * @return int рандомное число.
     */
    public static int randomNumberForCalc() {
        return ThreadLocalRandom.current().nextInt(NUMBER_FROM, NUMBER_TO);
    }
    /**
     * Рандомное число от 1 до 99.
     *
     * @return int рандомное число.
     */
    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt(1, NUMBER_TO);
    }
}
