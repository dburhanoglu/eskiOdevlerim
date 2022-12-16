package abininödev;


import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CoktanSecmeliSoru extends Soru{
	
	Scanner girilen = new Scanner(System.in);
//	private Sinav snv;
//	Vector<Soru> sorular = new Vector();
	
	
	public void CoktanSecmeliSoru() {	}
		
	@Override
	protected void Soruekle() {
		// TODO Auto-generated method stub
			
		System.out.println("Coktan Secmeli soru metnini giriniz::  [ Soru?  A)x B)y C)z ] formatýnda giriniz");
		this.metin=girilen.nextLine();
		System.out.println("Doðru cevap hangi seçenek");
		dogruSecenek=girilen.nextLine();
		System.out.println("Coktan Secmeli soru puanýný giriniz::");
		puan=girilen.nextInt();
		System.out.println("Coktan Secmeli soru zorluk giriniz::  KOLAY:0>>>NORMAL:1>>>>ZOR:2");
		zorluk=girilen.nextInt();
		

	}
		
	
	

	
	@Override
	protected void BDSoru() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	protected void SinavOlustur(Sinav snv) {
		
		for (int i=0;i<snv.sorular.size();i++) {	
			System.out.println((snv.sorular).get(i).getMetin());
			System.out.println("Cevabýnýz::");
			
			snv.sorular.get(i).cvp= girilen.nextLine(); }
		
	}

	@Override
	protected void DogruYanlisSoru() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KlasikSoru() {
		// TODO Auto-generated method stub
		
	}








	



	@Override
	protected void SinavOlustur() {
		// TODO Auto-generated method stub
		
	}


















}



