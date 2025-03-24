
public class Thread2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print("T2 | ");
			Thread.currentThread();
			Thread.yield();
		}
	}
}
