package SmokersProblem;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
	
    static Semaphore agent = new Semaphore(1);

    static Semaphore tobacco = new Semaphore(0);
    static Semaphore paper = new Semaphore(0);
    static Semaphore match = new Semaphore(0);

    static Random random = new Random();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Agent()).start();
        new Thread(new Smoker("Fumante com tabaco", tobacco)).start();
        new Thread(new Smoker("Fumante com papel", paper)).start();
        new Thread(new Smoker("Fumante com fósforo", match)).start();
	}

}
