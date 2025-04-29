package SmokersProblem;

import java.util.concurrent.Semaphore;

public class Smoker implements Runnable {

    private String name;
    private Semaphore semaphore;
    private Agent agent;
    private Counter counter;

    public Smoker(String name, Semaphore sem, Agent agent, Counter counter) {
        this.name = name;
        this.semaphore = sem;
        this.agent = agent;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                semaphore.acquire();

                if (!counter.isAlive(name)) {
                    System.out.println(name + " já não pode mais fumar.");
                    agent.release();
                    break;
                }

                System.out.println(name + " está fazendo o cigarro");
                Thread.sleep(800);

                System.out.println(name + " está fumando...");
                Thread.sleep(1500);

                counter.increment(name);

                System.out.println(name + " terminou de fumar. Total: " + counter.getCount(name));

                if (!counter.isAlive(name)) {
                    counter.smokerDie(name);
                }

                agent.release();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Thread interrompida");
        }
    }
}
