
public class ThreadJ1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.print("T1:" + i + " | ");
			Thread.currentThread();
			Thread.yield();
		}
	}
}
