package hopenihai;
//201913171047 Derya Burhanoðlu
//201813171006 Emine Ulusoy
//201513171808 Ayhan Beyaz
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import hopenihai.Coktansecmelisoru;
import java.io.*;

public class Test implements Serializable {

	public static void main(String[] args) {
		System.out.println("çoktan secmeli soru eklemek isterseniz 1 e basýn yoksa baska bir tuþa basabilirsiniz");
		Scanner kl1 = new Scanner(System.in);
		int giris = kl1.nextInt();
		if (giris == 1) {
			Soru c1 = new Coktansecmelisoru(null, null, null, giris, giris);
			c1.soruEkle();
			c1.soruSil();
			c1.soruSýrala();

		}
		System.out.println("Klasik soru eklemek isterseniz 2 ye basýn yoksa baska tusa");
		Scanner kl2 = new Scanner(System.in);
		int giris2 = kl2.nextInt();
		if (giris2 == 2) {

			Soru c2 = new Klasiksoru(null, giris, giris);
			c2.soruEkle();
			c2.soruSil();
			c2.soruSýrala();
		}
		System.out.println("doðru yanlis soru eklemek isterseniz 3 e basýn yoksa baska tusa");
		Scanner kl3 = new Scanner(System.in);
		int giris3 = kl3.nextInt();
		if (giris3 == 3) {

			Soru c3 = new Dysoru(null, null, giris, giris);
			c3.soruEkle();
			c3.soruSil();
			c3.soruSýrala();
		}
		System.out.println("bosluk soru eklemek isterseniz 4 e basýn yoksa baska tusa");
		Scanner kl4 = new Scanner(System.in);
		int giris4 = kl4.nextInt();
		if (giris4 == 4) {

			Soru c4 = new Bosluksoru(null, null, giris, giris);
			c4.soruEkle();
			c4.soruSil();
			c4.soruSýrala();
		}

		System.out.println("hangi türde sýnav istersiniz? test için 1 klasik için 2 karýþýk sýnav için 3 e basýn");
		Scanner tr = new Scanner(System.in);
		int tur = tr.nextInt();
		if (tur == 1) {
			Sinav m1 = new Testsinav(tur, null, null);
			m1.SinavOlustur();

		} else if (tur == 2)

		{
			Sinav m2 = new Klasiksinav(null, tur);
			m2.SinavOlustur();

		} else if (tur == 3) {
			Sinav m3 = new Karisiksinav(null, null, tur);
			m3.SinavOlustur();
		} else
			System.out.println("yanlýþ bir tuþa bastýnýz");

	}// Eger gerekli düzenlemeleri yapabilmiþ olsaydýk asagidaki kod ile soru
	// yazdýracaktýk
/*
* public class dosyayaKaydetme{ public static void main(String[] args){
* 
* File f= new File("sorular.txt");
* 
* Vector<Soru>cssorular=new Vector<>(); cssorular.add(s);
* Vector<Soru>dysorular=new Vector<>(); dysorular.add(s);
* Vector<Soru>boslukssorular=new Vector<>(); bosluksorular.add(s);
* Vector<Soru>klasiksorular=new Vector<>(); klasiksorular.add(s);
* 
* try { FileWriter fileWriter = new FileWriter(f,true);
* fileWriter.write("Soru: " + cssorular.get(i)); fileWriter.newLine();
* fileWriter.write("Verilen Cevap: " + verilenCevap.get(i));
* fileWriter.newLine(); fileWriter.write("Soru: " + dysorular.get(i));
* fileWriter.newLine(); fileWriter.write("Verilen Cevap: " +
* verilenCevap.get(i)); fileWriter.newLine(); fileWriter.write("Soru: " +
* bosluksorular.get(i)); fileWriter.write("Verilen Cevap: " +
* verilenCevap.get(i)); fileWriter.newLine(); fileWriter.write("Soru: " +
* klasiksorular.get(i)); fileWriter.newLine();
* fileWriter.write("Verilen Cevap: " + verilenCevap.get(i));
* fileWriter.newLine();
* fileWriter.write("-------------------------------------------------");
* fileWriter.newLine(); } fileWriter.close();
* 
* }catch(IO Exception e){ e.printStackTrace();
* 
* 
* 
* } }
*/

}
