package hexlet.code;

import java.util.concurrent.ThreadLocalRandom;

public final class Utils {
    private Utils() {
    }
    /**
     * рандомное число.
     * @param from от числа
     * @param to до числа
     * @return рандомное число
     */
    public static int randomNumber(final int from, final int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
