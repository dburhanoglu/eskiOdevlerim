package abinin�dev;


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
			
		System.out.println("Coktan Secmeli soru metnini giriniz::  [ Soru?  A)x B)y C)z ] format�nda giriniz");
		this.metin=girilen.nextLine();
		System.out.println("Do�ru cevap hangi se�enek");
		dogruSecenek=girilen.nextLine();
		System.out.println("Coktan Secmeli soru puan�n� giriniz::");
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
			System.out.println("Cevab�n�z::");
			
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



