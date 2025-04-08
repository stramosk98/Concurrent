package banheiro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bathroom {
	private Lock lock = new ReentrantLock();
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		lock.lock();
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
		
		lock.unlock();
	}

}
