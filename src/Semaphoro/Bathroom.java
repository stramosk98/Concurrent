package Semaphoro;

import java.util.concurrent.Semaphore;

public class Bathroom {
	private Semaphore sem = new Semaphore(1);
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(nome + " entrando no banheiro");
		System.out.println(nome + " iniciando atividade r�pida");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(nome + " terminou a atividade r�pida");
		System.out.println(nome + " dando descarga");
		System.out.println(nome + " lavando a m�o");
		System.out.println(nome + " saindo do banheiro");
		
		sem.release();
	}

}
