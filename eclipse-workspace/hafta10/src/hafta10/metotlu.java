package hafta10;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class metotlu {
public static int dogruSayisi=0;
public static String zorluk,kolay,zor,orta;
public static String puan;
static int i;
static Vector<String> sorular=new Vector<>();
static Vector<String> dysorular=new Vector<>();
static Vector<String> dycevaplar=new Vector<>();
static int girilen3;
public static String puan() {
	return puan;
	}
public static String zorluk(String zorluk) {
	return zorluk;
}

public static void dysoruekle() {
	System.out.println("kaç doðru yanlýþ sorusu girmek istiyorsunuz");
	Scanner klavye3=new Scanner(System.in);
	Integer girilen3=klavye3.nextInt();
	System.out.println("lütfen sýrasýyla 1 soru ve 1 de cevabý olacak þekilde sorularýn giriniz.cevabý d/y þeklinde giriniz.");
	for( i=0;i<girilen3;i++) {
	Scanner klavye=new Scanner(System.in);
 String girilen=klavye.nextLine();
 dysorular.add(girilen);
 Scanner klavye2=new Scanner(System.in);
 String girilen2=klavye2.nextLine();
 dycevaplar.add(girilen2);
 System.out.println("þimdi  bu sorunun zorluðunu giriniz.");
 Scanner klavye5=new Scanner(System.in);
 int girilen5=klavye5.nextInt();
 if(girilen5==1) {
dysorular.get(i).zorluk(kolay);	 


 }

 
	}
	System.out.println(dysorular);
	System.out.println(dycevaplar);
}
public static void dysorusil() {
	System.out.println("silmek istediðiniz soruda geçen kelimeyi yazýnýz");
	Scanner klavye4 =new Scanner(System.in);
	String girilen4=klavye4.nextLine();
	
	for(int j=0;j<dysorular.size();j++) {
	boolean b;
	b=dysorular.get(j).contains(girilen4);
	if(b==true) {
		sorular.set(j,null);
		System.out.println(dysorular);
	}
	else
	{ System.out.println("içermiyor");}
	
}
	System.out.println(dysorular);

}
public static void dysorulistele() {
	}
}

	
