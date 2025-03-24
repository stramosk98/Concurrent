package caldeira;

public class BoilerThread extends Thread {
	private double temperature;
	private Boiler boiler;
	
	public BoilerThread(double temperature)
	{
		this.temperature = temperature;
	}
	
 	@Override
	public void run() {
		
	}

}
