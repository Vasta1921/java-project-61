package hexlet.code;

import java.util.concurrent.ThreadLocalRandom;
import static hexlet.code.Engine.GameConstants.NUMBER_FROM;
import static hexlet.code.Engine.GameConstants.NUMBER_TO;

public final class Utils {
    private Utils() {
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
     *
     * @return int рандомное число.
     */
    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt(1, NUMBER_TO);
    }
}
