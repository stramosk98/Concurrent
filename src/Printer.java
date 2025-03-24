
public class Printer implements Runnable{
	String str;
	
	public Printer(String str) {
		this.str = str;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(str);
		}
	}
}
