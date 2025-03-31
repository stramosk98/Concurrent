package Aula03;

public class Waiter implements Runnable {
	private Message msg;
	public Waiter(Message m) {
		this.msg = m;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name +
						" waiting to get notified at time: "+
						System.currentTimeMillis());
				msg.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(name +
					" waiter thread got notified at time: " +
					System.currentTimeMillis());
			System.out.println(name + " processed" + msg.getMsg());
		}
	}

}
