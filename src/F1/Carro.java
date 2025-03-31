package F1;

import java.util.Random;

public class Carro {
	
	private final int DISTANCIA_TOTAL = 1000;
	private final int MAX_VELOCIDADE = 60;
	private final int SAFETY_CAR_LIMITE = 400;
	private int velocidade;
    private int distanciaPercorrida;
    private boolean entrandoBox = false;
    private Random random = new Random();
    private String nome;
    
    public Carro(String nome) {
    	this.nome = nome;
    	this.velocidade = 0;
    	this.distanciaPercorrida = 0;
    }
    
    public String getNome() {
    	return nome;
    }
	
    public synchronized void correr() {
        if (distanciaPercorrida >= DISTANCIA_TOTAL) return;
        updateVelocidade();
        distanciaPercorrida += velocidade;
        System.out.println(nome + " correu. Velocidade: " + velocidade 
                + " | Distância percorrida: " + distanciaPercorrida);
    }
    
    public synchronized void parar() {
        velocidade = 0;
        System.out.println(nome + " saiu da corrida por problema técnico");
    }
    
    public synchronized void passarBox() {
        System.out.println(nome + " entrando no box.");
        velocidade = Math.max(velocidade - random.nextInt(30), 0);
        entrandoBox = true;
        updateVelocidade();
        if (velocidade > MAX_VELOCIDADE) {
            System.out.println(nome + " foi penalizado por excesso de velocidade no box!");
            penalidade();
        }
        entrandoBox = false;
    }
    
    public synchronized void safetyCar() {
        if (velocidade > SAFETY_CAR_LIMITE) {
            System.out.println(nome + " reduziu velocidade devido ao safety car.");
            velocidade = SAFETY_CAR_LIMITE;
        } else {
            System.out.println(nome + " já está abaixo do limite do safety car.");
        }
    }
    
    public synchronized void penalidade() {
        int penalty = 50;
        distanciaPercorrida = Math.max(distanciaPercorrida - penalty, 0);
        System.out.println(nome + " sofreu penalidade, distância reduzida em " + penalty 
                + " unidades. Nova distância: " + distanciaPercorrida);
    }
    
    private synchronized void updateVelocidade() {
        if (!entrandoBox && velocidade < 400) {
            velocidade += random.nextInt(100);
        }
        System.out.println(nome + " velocidade atual: " + velocidade);
    }
    
    public synchronized boolean isFinished() {
        return distanciaPercorrida >= DISTANCIA_TOTAL;
    }
}
