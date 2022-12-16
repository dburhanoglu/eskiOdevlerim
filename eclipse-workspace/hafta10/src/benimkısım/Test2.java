package benimkýsým;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("ne türde soru eklemek isersin?test için 1 e dy için 2 ye klasik için 3 e bosluk iin 4 e bas");
Scanner klavye9=new Scanner(System.in);
int girilen9=klavye9.nextInt();
switch(1) {
case 1: 
case 2: 
case 3:{
	Sorucl n1=new klasiksr();
	
	n1.soruEkle(null);
	n1.soruSil(null);
	n1.getZorluk();
	n1.getMetin();
	n1.getpuan();
	
	
    }
case 4: break;


}
	}}
Sorucl n1=new klasiksr();

System.out.println("kaç tane klasik eklemek soru istiyorsunuz");
Scanner klavye3=new Scanner(System.in);
int girilen3=klavye3.nextInt();
for(int i=0;i<girilen3;i++) {
	
System.out.println("soru gir zorlýk gir paun gir");
		Scanner klavye2=new Scanner(System.in);
	String girilen2=klavye2.nextLine();
	n1.soruEkle(girilen2);
	Integer girim=klavye2.nextInt();
	n1.setZorluk(girim);
	
	
}System.out.println(sorular.get(2).getzorluk());
 }
