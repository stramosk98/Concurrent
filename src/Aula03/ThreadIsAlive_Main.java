package Aula03;

public class ThreadIsAlive_Main extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadIsAlive ta = new ThreadIsAlive();
		ta.start();
		while (ta.isAlive()) {
			System.out.println("Thread Ativa");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Thread Inativa");
	}

}
