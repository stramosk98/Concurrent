package exerciciosAula02;

import java.util.Random;

public class Boiler {
	
	private int temperature;
	private boolean isOn = false;
	final double MAX_TEMPERATURE = 1600;
	private final Random random = new Random();

	public synchronized void turnOn() {
		if (isOn) {
			System.out.println("A caldeira já esta ligada");
			return;
		}
		
		isOn = true;
		System.out.println("Ligando a caldeira...");
		updateTemperature();
	}
	
	public synchronized void turnOff() {
		if (!isOn) {
			System.out.println("A caldeira já esta desligada");
			return;
		}
		
		isOn = false;
		System.out.println("Desligando a caldeira...");
	}
	
	public synchronized void clean() {
		if (isOn) {
            System.out.println("Não é possível limpar enquanto a caldeira está ligada!");
            return;
        }

        System.out.println("Limpando a caldeira...");
	}
	
	public synchronized void feed() {
		if (!isOn) {
			System.out.println("A caldeira precisa estar ligada para ser alimentada!");
	        return;
	    }
		
	    System.out.println("Alimentando a caldeira...");
	    updateTemperature();
	}
	
	private synchronized void updateTemperature() {
		temperature += random.nextInt(200);
		System.out.println("Temperatura atual: " + temperature + "°C");
	
		if (temperature > MAX_TEMPERATURE) {
		    System.out.println("Temperatura CRÍTICA! Desligando a caldeira...");
		    turnOff();
		}
        }
	
	public boolean isOn() {
		return isOn;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
    
   
}
