package SmokersProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Agent implements Runnable {

    private Semaphore agent, tobacco, match, paper;
    private Random random;
    private Counter counter;

    public Agent(Semaphore agent, Semaphore tobacco, Semaphore paper, Semaphore match, Counter counter) {
        this.agent = agent;
        this.tobacco = tobacco;
        this.paper = paper;
        this.match = match;
        this.counter = counter;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (counter.haveSmokersAlive()) {
                agent.acquire();
                System.out.println();
                
                List<Integer> choices = getAvailableChoices();
                if (choices.isEmpty()) break;
                int choice = choices.get(random.nextInt(choices.size()));
                switch (choice) {
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

            System.out.println("\nTodos os fumantes morreram. Agente encerrando.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        agent.release();
    }
    
    private List<Integer> getAvailableChoices() {
        List<Integer> choices = new ArrayList<>();
        if (counter.isAlive("Fumante com tabaco")) choices.add(0);
        if (counter.isAlive("Fumante com fósforo")) choices.add(1);
        if (counter.isAlive("Fumante com papel")) choices.add(2);
        return choices;
    }

}
