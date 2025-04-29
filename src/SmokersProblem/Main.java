package SmokersProblem;

import java.util.concurrent.Semaphore;

public class Main {

    static Semaphore agentSem = new Semaphore(1);
    static Semaphore tobacco = new Semaphore(0);
    static Semaphore paper = new Semaphore(0);
    static Semaphore match = new Semaphore(0);

    public static void main(String[] args) {

        Counter counter = new Counter(3);
        Agent agent = new Agent(agentSem, tobacco, paper, match, counter);

        new Thread(agent).start();
        new Thread(new Smoker("Fumante com tabaco", tobacco, agent, counter)).start();
        new Thread(new Smoker("Fumante com papel", paper, agent, counter)).start();
        new Thread(new Smoker("Fumante com fósforo", match, agent, counter)).start();
    }
}
