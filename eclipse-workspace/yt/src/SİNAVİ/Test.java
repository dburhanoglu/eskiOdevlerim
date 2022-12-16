package SÝNAVÝ;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Hesap o1=new Hesap("eylül",1,99);
Musteri o2=new Musteri(null, o1);
o2.setHesap(o1);
	}

}
