package exercise09;

import java.util.Random;

public class MyThread1 extends Thread {
    private SharedResource shared;
    private Random random = new Random();

    public MyThread1(SharedResource shared) {
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
