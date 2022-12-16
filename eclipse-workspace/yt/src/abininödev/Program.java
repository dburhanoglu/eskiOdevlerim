package abininödev;
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
	
		System.out.println("Girmek istediðiniz soru tipini seçiniz...\n" 
				+ "\n 1. Çoktan Seçmeli"
				+ "\n 2.Doðru/Yanlýþ"
				+ "\n 3.Boþluk Doldurma"
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
				+"Ana Menüye dön>>1");
		int devam=girilen.nextInt();
		if (devam==1)
			break;
		else
		i=devam;
		 } } else if (secim==2)
		
			
		 {
	
		 System.out.println("Silmek istediðiniz soruda geçen kelimeyi arayýnýz");
		 String	arama=girilen2.nextLine();
		sb.soruAra(arama);
		
		
	
		 } else if (secim==3) {
			Collections.sort(test.sorular);
			for (Soru Tsoru:test.sorular) {
				
				System.out.println("puaný::"+Tsoru.getPuan()+ 	"Soru metni::"+Tsoru.getMetin());
			}
		 }
			
			else if (secim==4)
		
		 {
			System.out.println("Olmak istediðiniz Sýnav türü nedir? \n" 
					+ "\n 1. Test Sinav"
					+ "\n 2. Klasik Sinav"
					+ "\n 3.Karýþýk Sinav"
					);
			int secim11=girilen.nextInt();
			if (secim11==1) {
				System.out.println(":::::::::::::Test Sinava Hosgeldiniz:::::::::");
			cs.SinavOlustur(test);
			} else if (secim11==2) {
				System.out.println(":::::::::::::Klasik Sinava Hosgeldiniz:::::::::");
			}else if (secim11==3) {				
				System.out.println(":::::::::::::Karýþýk Sinava Hosgeldiniz:::::::::");
			}
			
		}
			else if (secim==5)
	
		 {
			System.out.println("Cikis yapildi.");
			System.exit(0);
			}
		 } 
	 

}
	


