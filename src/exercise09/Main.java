package exercise09;

public class Main {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();
        Thread MyThread1 = new MyThread1(shared);
        Thread MyThread2 = new MyThread2(shared);

        MyThread1.start();
        MyThread2.start();
    }
}
