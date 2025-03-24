package exercise10;

class SharedResource {
    private boolean evenTurn = true;

    public synchronized void printEven(int number) {
        while (!evenTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Par: " + number);
        evenTurn = false;
        notify();
    }

    public synchronized void printOdd(int number) {
        while (evenTurn) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Ímpar: " + number);
        evenTurn = true;
        notify();
    }
}