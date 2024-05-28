package exercise;

import java.util.Arrays;

class SafetyList {
    public final int[] list = new int[4000];
    private int index = 0;

    // BEGIN
    synchronized void add(int number) {
        list[index] = number;
        index++;
    }

    int get(int index) {
        return list[index];
    }

    int getSize() {
        long size = Arrays.stream(list)
                .filter(x -> x != 0)
                .count();
        return Long.valueOf(size).intValue();
    }
    // END
}
