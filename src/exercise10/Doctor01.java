package exercise10;

import java.util.Random;

public class Doctor01 extends Thread {
    private SharedResource shared;
    private Random random = new Random();

    public Doctor01(SharedResource shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(100);
            if (number % 2 == 0) {
                shared.printEven(number);
            } else {
                i--;
            }
        }
    }
}
