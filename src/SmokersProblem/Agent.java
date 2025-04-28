package SmokersProblem;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Agent implements Runnable {

    private Semaphore agent, tobacco, match, paper;
    private Random random;

    public Agent(Semaphore agent, Semaphore tobacco, Semaphore paper, Semaphore match) {
        this.agent = agent;
        this.tobacco = tobacco;
        this.paper = paper;
        this.match = match;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                agent.acquire();

                int escolha = random.nextInt(3);
                switch (escolha) {
                    case 0:
                        System.out.println("Agente colocou papel e fósforo");
                        tobacco.release();
                        break;
                    case 1:
                        System.out.println("Agente colocou papel e tabaco");
                        match.release();
                        break;
                    case 2:
                        System.out.println("Agente colocou tabaco e fósforo");
                        paper.release();
                        break;
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        agent.release();
    }
}
