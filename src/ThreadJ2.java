
public class ThreadJ2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.print("T2:" + i + " | ");
			Thread.currentThread();
			Thread.yield();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
