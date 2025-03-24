package exercise08;

public class Main {

	public static void main(String[] args) {
		int numThreads = 3;
        int platesPerThread = 5;

        for (int i = 0; i < numThreads; i++) {
            MyThread thread = new MyThread(platesPerThread);
            thread.start();
        }
	}

}
