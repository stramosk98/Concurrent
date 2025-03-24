
public class Printer1 implements Runnable{
	String str;
	
	public Printer1(String str) {
		this.str = str;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(str);
			Thread.currentThread();
			Thread.yield();
		}
	}
}
