package exercise;

import java.util.Random;

// BEGIN
class ListThread extends Thread {
    private final SafetyList safetyList;

    ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            safetyList.add(random.nextInt());
        }
    }
}
// END
