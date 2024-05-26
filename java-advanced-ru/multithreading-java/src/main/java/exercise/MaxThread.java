package exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

// BEGIN
public class MaxThread extends Thread {
    private int max;
    private final int[] numbers;
    private final Logger logger;

    public MaxThread(int[] numbers, Logger logger) {
        this.numbers = numbers;
        this.logger = logger;
    }

    @Override
    public void run() {
        logger.info("Thread " + Thread.currentThread().getName() + " started");
        max = Arrays.stream(numbers).max().getAsInt();
        logger.info("Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMax() {
        return max;
    }
}
// END
