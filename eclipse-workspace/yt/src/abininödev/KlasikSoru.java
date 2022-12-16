package abininödev;

import java.util.Scanner;
import java.util.Vector;

import hopenihai.Coktansecmelisoru;
import hopenihai.Klasiksoru;

public class KlasikSoru extends Soru {
	
	Scanner girilen = new Scanner(System.in);
	
	public Vector<Soru> sorular = new Vector();
String metin;
int puan,zorluk;
public KlasikSoru(String metin,int puan ,int zorluk) {
		super();
		this.metin=metin;
		this.puan=puan;
		this.zorluk=zorluk;
		
		
	}

	public Vector<Soru> getSorular() {
		return sorular;
	}

	public void setSorular(Vector<Soru> sorular) {
		this.sorular = sorular;
	}

		@Override
	protected void Soruekle() {
			System.out.println("kac klasik soru gireceksiniz?");
			Scanner kl=new Scanner(System.in);
			int kac=kl.nextInt();
			for(int i=0;i<kac;i++) {
	System.out.println("Klasik soru metnini giriniz::");
		metin=girilen.nextLine();
		System.out.println("Klasik soru puanýný giriniz::");
		puan=girilen.nextInt();
		System.out.println("Klasik soru zorluk giriniz::  KOLAY:0>>>NORMAL:1>>>>ZOR:2");
		zorluk=girilen.nextInt();
	    sorular.add(new KlasikSoru(metin,puan,zorluk));
			}
		}

	@Override
		public String toString() {
			return "KlasikSoru [sorular=" + sorular + "]";
		}

	public void SoruAra(String arama, Sinav snv) {
		for(int i=0;i< snv.sorular.size();i++) {
			boolean b=snv.sorular.get(i).getMetin().contains(arama);
			if(b==true) 
			{System.out.println(snv.sorular.get(i));}
			}
		
		
		
		}

	@Override
	protected void SinavOlustur() {
		// TODO Auto-generated method stub
		
	}




/*	@Override

	protected void SoruAra() {
		// TODO Auto-generated method stub
		
	}*/
}


