package aula02;

public class BaixaPrioridade extends Thread {
	public void run() {
		setPriority(1);
		for (int i = 0; i < 10; i++) {
			System.out.println("Baixa prioridade...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.exit(0);
			}
		}
	}
}
