package aula02;

public class AltaPrioridade extends Thread {
	public void run() {
		setPriority(10);
		for (int i = 0; i < 10; i++) {
			System.out.println("Alta prioridade...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.exit(0);
			}
		}
	}
}
