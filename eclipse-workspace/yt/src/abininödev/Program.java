package abinin�dev;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;



public class Program {
	public static Vector<Soru> sorular = new Vector();
	public static void main(String[] args) {
		Scanner girilen = new Scanner(System.in);
		Scanner girilen2 = new Scanner(System.in);
		Scanner girilen3 = new Scanner(System.in);
		Soru cs= new CoktanSecmeliSoru();
		Soru dy= new DogruYanlisSoru();
		Soru bd= new BDSoru();
		Soru ks= new KlasikSoru(null, 0, 0);
		Sinav test= new TestSinav();
		Sinav klasik= new KlasikSinav(null);
		Sinav karisik= new KarisikSinav(null);
		Sinav sb=new SoruBankasi();

		System.out.println("Merhaba Sinav Uygulamasina hosgeldiniz \n" 
				+ "\n 1. Soru Bankasina Soru Ekle "
				+ "\n 2. Soru Bankasindan Soru Cikar "
				+ "\n 3. Soru Bankasindan Soru Listele"
				+ "\n 4. Sinav Olustur"
				+ "\n 5. Cikis Yap");
		
		 int secim=girilen.nextInt();
	 if (secim==1)
		 { for (int i=0;i<2;i++) {
	
		System.out.println("Girmek istedi�iniz soru tipini se�iniz...\n" 
				+ "\n 1. �oktan Se�meli"
				+ "\n 2.Do�ru/Yanl��"
				+ "\n 3.Bo�luk Doldurma"
				+ "\n 4. Klasik soru");
		int tip = girilen.nextInt();
		if(tip==1 ) {
			
			cs.Soruekle();
			test.soruEkle(cs);}
		else if (tip==2) {
			dy.Soruekle();
			karisik.soruEkle(ks);} 
		else if (tip==3) {
			bd.Soruekle();
			karisik.soruEkle(bd);}
		else if (tip==4)
			{
			ks.Soruekle();	
			klasik.soruEkle(ks);
			}
		System.out.println("Yeni Soru ekle>>0\n"
				+"Ana Men�ye d�n>>1");
		int devam=girilen.nextInt();
		if (devam==1)
			break;
		else
		i=devam;
		 } } else if (secim==2)
		
			
		 {
	
		 System.out.println("Silmek istedi�iniz soruda ge�en kelimeyi aray�n�z");
		 String	arama=girilen2.nextLine();
		sb.soruAra(arama);
		
		
	
		 } else if (secim==3) {
			Collections.sort(test.sorular);
			for (Soru Tsoru:test.sorular) {
				
				System.out.println("puan�::"+Tsoru.getPuan()+ 	"Soru metni::"+Tsoru.getMetin());
			}
		 }
			
			else if (secim==4)
		
		 {
			System.out.println("Olmak istedi�iniz S�nav t�r� nedir? \n" 
					+ "\n 1. Test Sinav"
					+ "\n 2. Klasik Sinav"
					+ "\n 3.Kar���k Sinav"
					);
			int secim11=girilen.nextInt();
			if (secim11==1) {
				System.out.println(":::::::::::::Test Sinava Hosgeldiniz:::::::::");
			cs.SinavOlustur(test);
			} else if (secim11==2) {
				System.out.println(":::::::::::::Klasik Sinava Hosgeldiniz:::::::::");
			}else if (secim11==3) {				
				System.out.println(":::::::::::::Kar���k Sinava Hosgeldiniz:::::::::");
			}
			
		}
			else if (secim==5)
	
		 {
			System.out.println("Cikis yapildi.");
			System.exit(0);
			}
		 } 
	 

}
	


