package exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

// BEGIN
public class MinThread extends Thread {
    private int min;
    private final int[] numbers;
    private final Logger logger;

    public MinThread(int[] numbers, Logger logger) {
        this.numbers = numbers;
        this.logger = logger;
    }

    @Override
    public void run() {
        logger.info("Thread " + Thread.currentThread().getName() + " started");
        min = Arrays.stream(numbers).min().getAsInt();
        logger.info("Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMin() {
        return min;
    }
}
// END
