package F1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numCarros = 5;
        List<String> resultados = Collections.synchronizedList(new ArrayList<>());
        CarroThread[] threads = new CarroThread[numCarros];

        for (int i = 0; i < numCarros; i++) {
            Carro carro = new Carro("#" + (i+1));
            threads[i] = new CarroThread(carro, resultados);
        }

        for (CarroThread ct : threads) {
            ct.start();
        }

        for (CarroThread ct : threads) {
            try {
                ct.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nOrdem de chegada:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i+1) + " - " + resultados.get(i));
        }
    }
}
