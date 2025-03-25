package exerciciosAula02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Boiler boiler = new Boiler();

        BoilerThread turnOnThread = new BoilerThread(boiler, "Ligando", Thread.MIN_PRIORITY);
        BoilerThread feedThread = new BoilerThread(boiler, "Alimentando", Thread.MIN_PRIORITY);
//        BoilerThread turnOffThread = new BoilerThread(boiler, "Desligando", Thread.MAX_PRIORITY);
        BoilerThread cleanThread = new BoilerThread(boiler, "Limpando", Thread.MIN_PRIORITY);

        turnOnThread.start();
        feedThread.start();
//        turnOffThread.start();
        cleanThread.start();

        try {
            turnOnThread.join();
            feedThread.join();
//            turnOffThread.join();
            cleanThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sistema finalizado");
	}
	
}
