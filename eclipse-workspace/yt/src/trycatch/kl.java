package trycatch;

public class kl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		 

		int a = 3 - 3;
		int b = 2 / a;
		System.out.println("" + b);

	}

	catch (ArithmeticException e1) {
		e1.getStackTrace();

	} catch (RuntimeException e2)  {
		System.err.print("heeyy");
	}

	finally {
	}

	

	}

}