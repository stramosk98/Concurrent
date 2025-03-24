package exercise08;

public class MyThread extends Thread {
	int number = 0;
	MyThread(int number) {
		this.number = number;
	}
	@Override
	public void run() {
		for (int i = 0; i < number; i++) {
			System.out.println(MyThread.currentThread().getName() + ": " + RandomPlate.generatePlate());
			MyThread.currentThread();
			MyThread.yield();
		}
	}
}
