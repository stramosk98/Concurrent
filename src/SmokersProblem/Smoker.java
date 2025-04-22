package SmokersProblem;

import java.util.concurrent.Semaphore;

public class Smoker implements Runnable {
	
	private String name;
	private Semaphore semaphore;
	
	public Smoker (String name, Semaphore sem) {
		this.name = name;
		this.semaphore = sem;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
