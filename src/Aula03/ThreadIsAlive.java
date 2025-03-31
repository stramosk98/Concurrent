package Aula03;

public class ThreadIsAlive extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
