package exercise10;

public class Main {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();
        Thread MyThread1 = new Doctor01(shared);
        Thread MyThread2 = new Doctor02(shared);

        MyThread1.start();
        MyThread2.start();
    }
}
