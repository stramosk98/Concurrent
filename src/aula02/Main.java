package aula02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AltaPrioridade a = new AltaPrioridade();
		BaixaPrioridade b = new BaixaPrioridade();
		System.out.println("iniciado thread");
		b.start();
		a.start();
		Thread.currentThread();
		Thread.yield();
		System.out.println("Main finalizado");
	}

}
