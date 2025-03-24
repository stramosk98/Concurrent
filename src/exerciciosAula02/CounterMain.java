package exerciciosAula02;

import java.util.Random;

public class CounterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		boolean even = random.nextInt() % 2 == 0;

		CounterThread low = new CounterThread(Thread.MIN_PRIORITY, even);
		CounterThread high = new CounterThread(Thread.MAX_PRIORITY, !even);
		
		System.out.println("Threads starts");
		
		low.start();
		high.start();
		
		try {
			low.join();
			high.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Threads finished");
	}

}
