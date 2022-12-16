package abininödev;


import java.util.Scanner;
import java.util.Vector;

public class DogruYanlisSoru extends Soru {
	public Vector<Soru> sorular = new Vector();
	Scanner girilen = new Scanner(System.in);
	private boolean dogruMu;
	public boolean isDogruMu() {
	return dogruMu;
	}
	public void setDogruMu(boolean dogruMu) {
	this.dogruMu = dogruMu;
	}
	/*String metin;
	int zorluk,puan;*/

public void DogruYanlisSoru() {}
@Override
protected void Soruekle() {
	// TODO Auto-generated method stub
	System.out.println("DY soru metnini giriniz::");
	metin=girilen.nextLine();
	System.out.println("DY soru puanýný giriniz::");
	puan=girilen.nextInt();
	System.out.println("DY soru zorluk giriniz::  KOLAY:0>>>NORMAL:1>>>>ZOR:2");
	zorluk=girilen.nextInt();
	//sorular.add(new DogruYanlisSoru(metin,puan,zorluk));
}
@Override
protected void SinavOlustur() {
	// TODO Auto-generated method stub
	
}







}
