package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static void main(String[] args) {

    }

    public static Map<String, Integer> getMinMax(int[] numbers)  {
        // BEGIN
        MinThread minThread = new MinThread(numbers, LOGGER);
        MaxThread maxThread = new MaxThread(numbers, LOGGER);
        minThread.start();
        maxThread.start();
        try {
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Map.of("min", minThread.getMin(),
                "max", maxThread.getMax());
    }
    // END
}
