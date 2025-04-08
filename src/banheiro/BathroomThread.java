package banheiro;

import java.util.List;
import java.util.Random;

public class BathroomThread extends Thread {
    private List<String> resultados;
    private Random random = new Random();
    private String nome;
    private Boolean finalizou = false;

    public BathroomThread(String nome) {
        this.nome = nome;
//        this.resultados = resultados;
    }

    @Override
    public void run() {
        try {
            while (!finalizou) {
                int action = random.nextInt(10);
                
                if (action < 7) {
                	System.out.println(nome + ": 1 - Rápido");
                	Thread.sleep(500);
                } else {
                	System.out.println(nome + ": 2 - Demorado");
                	Thread.sleep(1000);
                }
                
                finalizou = true;
            }
            
            
        } catch (InterruptedException e) {
            System.out.println(nome + " thread interrompida");
        }
    }
}
