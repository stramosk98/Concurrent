package SmokersProblem;

import java.util.concurrent.Semaphore;

public class Main {
	
    static Semaphore agentSem = new Semaphore(1);

    static Semaphore tobacco = new Semaphore(0);
    static Semaphore paper = new Semaphore(0);
    static Semaphore match = new Semaphore(0);
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Agent agent = new Agent(agentSem, tobacco, paper, match);
		new Thread(agent).start();
        new Thread(new Smoker("Fumante com tabaco", tobacco, agent)).start();
        new Thread(new Smoker("Fumante com papel", paper, agent)).start();
        new Thread(new Smoker("Fumante com fósforo", match, agent)).start();
	}

}
