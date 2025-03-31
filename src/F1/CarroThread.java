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
    	boolean jaParou = false;
        try {
            while (true) {
                if (carro.isFinished()) {
                    System.out.println(carro.getNome() + " terminou a corrida!");
                    synchronized(resultados) {
                        resultados.add(carro.getNome());
                    }
                    break;
                }
                
            	int acao = random.nextInt(8);
                
                if (acao <= 4) {
                    carro.correr();
                } else if (acao == 5) {
                    carro.passarBox();
                } else if (acao == 6) {
                    carro.safetyCar();
                } else if (acao == 7 && !jaParou) {
                    carro.parar();
                    synchronized(resultados) {
                        resultados.add(carro.getNome() + " (Problema Técnico)");
                    }
                    jaParou = true;
                    return; // Encerra a thread pois o carro saiu da corrida
                }
                
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
