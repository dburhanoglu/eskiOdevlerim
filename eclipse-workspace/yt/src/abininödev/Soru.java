package abininödev;



import java.util.Scanner;
import java.util.Vector;

public abstract class Soru implements Comparable<Soru>  {
	protected int puan;
	protected String metin, cvp, dogruSecenek, girilenSecenek,arama;
	protected int zorluk;
	protected int tip;
	public static final int KOLAY=0;
	public static final int NORMAL=1;
	public static final int ZOR=2;
	
	public String getDogruSecenek() {
		return dogruSecenek;
	}
	public void setDogruSecenek(String dogruSecenek) {
		this.dogruSecenek = dogruSecenek;
	}
	
	public int getTip() {
		return tip;
	}
	public void setTip(int tip) {
		this.tip = tip;
	}

	public int getPuan() {
	return puan;
	}
	public void setPuan(int puan) {
	this.puan = puan;
	}
	public String getMetin() {
	return metin;
	}
	public void setMetin(String metin) {
	this.metin = metin;
	}
	public int getZorluk() {
	return zorluk;
	}
	public void setZorluk(int zorluk) {
	this.zorluk = zorluk;
	}
protected abstract void Soruekle() ;//bu metot farklý türde sorularý kullanýcýdan almamýzý saðlar

	protected abstract void SinavOlustur();
//	protected abstract void SoruAra(String arama, Vector<Soru> sorular);
	//protected abstract void SoruAra(String arama, Vector<Soru> sorular);

	protected void SinavOlustur(Soru s) {
		// TODO Auto-generated method stub
		
	}
	protected void SinavOlustur(Sinav snv) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int compareTo(Soru s) {
		if (this.puan>s.puan) return 1;
		if (this.puan<s.puan) return -1;
		return puan;}
	protected void soruAra() {
		// TODO Auto-generated method stub
		
	}

		
		

	
	
}
