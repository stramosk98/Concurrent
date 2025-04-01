package F1;

import java.util.Random;

public class Carro {
    private final int DISTANCIA_TOTAL = 100;
    private final int MAX_VELOCIDADE_BOX = 43;
    private final int SAFETY_CAR_LIMITE = 120;
    private int velocidade;
    private int distanciaPercorrida;
    private boolean inPit = false;
    private Random random = new Random();
    private String nome;
    private int pitStopCount = 0;
    private boolean parou = false;
    
    public Carro(String nome) {
        this.nome = nome;
        this.velocidade = 50 + random.nextInt(30);
        this.distanciaPercorrida = 0;
    }
    
    public String getNome() {
        return nome;
    }
    
	public synchronized void correr() {
        if (parou || inPit) return;
        
        int acceleration = 10 + random.nextInt(20);
        velocidade = Math.min(velocidade + acceleration, SAFETY_CAR_LIMITE);
    }
    
    public synchronized void frear() {
        if (parou) return;
        
        int braking = 10 + random.nextInt(30);
        velocidade = Math.max(velocidade - braking, 0);
    }
    
    public synchronized void pitStop() {
        if (parou || inPit) return;
        
        inPit = true;
        pitStopCount++;
        System.out.println(nome + " entrando no box (" + pitStopCount + ")");
        velocidade = 30 + random.nextInt(20);
        distanciaPercorrida += 5;
        inPit = false;

        if (velocidade > MAX_VELOCIDADE_BOX) {
        	distanciaPercorrida = Math.max(distanciaPercorrida - 15, 0); 
			System.out.println("Alta velocidade no pitStop, Penalizado!");
        }
    }
    
    public synchronized void parar() {
        parou = true;
        velocidade = 0;
        System.out.println(nome + " parou por problemas tecnicos!");
    }
    
    public synchronized void mover() {
        if (parou) return;
        
        int variation = random.nextInt(21) - 10;
        velocidade = Math.max(10, Math.min(velocidade + variation, SAFETY_CAR_LIMITE));
        
        distanciaPercorrida += velocidade / 10;
    }
    
    public synchronized boolean finalizou() {
        return distanciaPercorrida >= DISTANCIA_TOTAL || parou;
    }
    
    public synchronized int getDistance() {
        return distanciaPercorrida;
    }
    
    public synchronized boolean parou() {
        return parou;
    }
    
    public synchronized String drawCar() {
        StringBuilder sb = new StringBuilder();
        
        int pos = Math.min(distanciaPercorrida / 5, 15);
        sb.append(" ".repeat(pos));
        
        if (parou) {
            sb.append("X ");
        } else if (inPit) {
            sb.append("P ");
        }
        
        sb.append("  ____\n");
        sb.append(" ".repeat(pos));
        sb.append(" /|_||_\\`.__\n");
        sb.append(" ".repeat(pos));
        sb.append("(    ").append(nome).append("  _ _\\vel: " + velocidade + " dist: " + distanciaPercorrida + "\n");
        sb.append(" ".repeat(pos));
        sb.append("=`-(_)--(_)-'");
        
        return sb.toString();
    }
}