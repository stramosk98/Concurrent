package F1;

import java.util.List;
import java.util.Random;

public class CarroThread extends Thread {
    private Carro carro;
    private List<String> resultados;
    private Random random = new Random();

    public CarroThread(Carro carro, List<String> resultados) {
        this.carro = carro;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        try {
            while (!carro.finalizou()) {
                int action = random.nextInt(100);
                
                if (action < 60) {
                    carro.correr();
                } else if (action < 80) {
                    carro.frear();
                } else if (action < 95) {
                    carro.pitStop();
                } else {
                    carro.parar();
                }
                
                carro.mover();
                
                System.out.println(carro.drawCar());
                System.out.println("-".repeat(30));
                
                Thread.sleep(500);
            }
            
            if (carro.getDistance() >= 100) {
                synchronized(resultados) {
                    resultados.add(carro.getNome());
                }
            }
            
        } catch (InterruptedException e) {
            System.out.println(carro.getNome() + " thread interrompida");
        }
    }
}