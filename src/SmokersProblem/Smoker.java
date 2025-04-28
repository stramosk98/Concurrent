package SmokersProblem;

import java.util.concurrent.Semaphore;

public class Smoker implements Runnable {

    private String name;
    private Semaphore semaphore;
    private Agent agent;

    public Smoker(String name, Semaphore sem, Agent agent) {
        this.name = name;
        this.semaphore = sem;
        this.agent = agent;
    }

    @Override
    public void run() {
        try {
            while (true) {
                semaphore.acquire();
                System.out.println(name + " está fazendo o cigarro");
                Thread.sleep(500);

                System.out.println(name + " está fumando");
                Thread.sleep(1200);

                System.out.println(name + " terminou de fumar");
                agent.release();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Thread interrompida");
        }
    }
}
