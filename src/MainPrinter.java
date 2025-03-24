
public class MainPrinter {

	public static void main(String[] args) {
//		new Thread(new Printer("A")).start();
//		new Thread(new Printer("B")).start();
		new Thread(new Printer1("A")).start();
		new Thread(new Printer1("B")).start();
	}

}
