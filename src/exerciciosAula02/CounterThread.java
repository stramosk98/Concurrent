package exerciciosAula02;

public class CounterThread extends Thread {
	private int priority;
	private boolean sleep;
	
	public CounterThread(int priority, boolean even) {
		this.priority = priority;
		this.sleep = even;
		setPriority(priority);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Priority: " + priority + " - index: " + i);
			
			if (sleep) {
				try {
					System.out.println("Waiting priority: " + priority );
					sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					System.exit(0);
				}
			}
				
		}
	}
}
