package hafta10;

import java.util.Scanner;
import java.util.Vector;

public class boslukicin {
	static Vector<String> bosluksorular=new Vector<>();
	static Vector<String> boslukcevaplar=new Vector<>();
	String kolay,orta,zor;
	public String zorluk(String seviye) {
		return seviye;
	}
public void bosluksoruekle() {
	System.out.println("kaç tane soru ekleyeceðinizi giriniz");
	Scanner kl=new Scanner(System.in);
	int bossorsayisi=kl.nextInt();
	System.out.println("sýrasýyla o önce soruyu sonra cevabý olacak þekilde soru ve cevaplarý girin,z sýnra da zorluðunu girinzi");
for(int i=0;i<bossorsayisi;i++) {
	Scanner kl2=new Scanner(System.in);
	String bossoru=kl2.nextLine();
	String boscevap=kl2.nextLine();
	bosluksorular.add(bossoru);
    boslukcevaplar.add(boscevap);
			String seviye=kl2.nextLine();
			if(seviye.equals(zor)==1) {
			bosluksorular.get(i).zorluk(zor);
			}
}
	System.out.println(bosluksorular);
	System.out.println(boslukcevaplar);
	
}
}
