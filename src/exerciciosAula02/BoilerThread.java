package exerciciosAula02;

class BoilerThread extends Thread {
    private Boiler boiler;
    private String action;
    
    public BoilerThread(Boiler boiler, String action, int priority) {
        this.boiler = boiler;
        this.action = action;
        setPriority(priority);
    }

    @Override
    public void run() {
        try {
            while (true) {
                switch (action) {
                    case "Ligando":
                        boiler.turnOn();
                        break;
                    case "Alimentando":
                        boiler.feed();
                        break;
                    case "Limpando":
                        boiler.clean();
                        break;
                    case "Desligando":
                        boiler.turnOff();
                        break;
                }
                
                Thread.sleep(1000);
                if (!boiler.isOn()) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
