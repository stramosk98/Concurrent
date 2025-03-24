package caldeira;

public class Boiler {
	
	private double temperature;
	final double ALLOW_TEMPERATURE = 1.600;
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	private void turnOn() {
		this.allowTemperature();
		System.out.println("Ligando a caldeira...");
	}
	
	private void turnOff() {
		this.allowTemperature();
		System.out.println("Desligando a caldeira...");
	}
	
	private void clear() {
		this.allowTemperature();
		System.out.println("Limpando a caldeira...");
	}
	
	private void feed() {
		this.allowTemperature();
		System.out.println("Alimentando a caldeira...");
	}
	
	private boolean allowTemperature() {
		if (getTemperature() > ALLOW_TEMPERATURE) {
			System.out.println("Temperatura acima do permitido - " + getTemperature());
			return false;
		}
		return true;
	}
}
