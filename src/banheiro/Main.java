package banheiro;

import Semaphoro.Bathroom;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bathroom banheiro = new Bathroom();

		Runnable pessoa = () -> {
			banheiro.fazNumero1();
		};

		Thread pessoa1 = new Thread(pessoa, "João");
		Thread pessoa2 = new Thread(pessoa, "Maria");
		Thread pessoa3 = new Thread(pessoa, "Carlos");

		pessoa1.start();
		pessoa2.start();
		pessoa3.start();
    }

}
