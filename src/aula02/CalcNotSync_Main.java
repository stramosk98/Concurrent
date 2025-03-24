package aula02;

public class CalcNotSync_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = {1,2,3};
		CalcNotSync c1 = new CalcNotSync("T1", v);
		CalcNotSync c2 = new CalcNotSync("T2", v);
		c1.run();
		c2.run();
	}

}
