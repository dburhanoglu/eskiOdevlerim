package abininödev;


import java.util.Scanner;
import java.util.Vector;

public abstract class Sinav {
	Scanner girilen = new Scanner(System.in);
	public Vector<Soru> sorular = new Vector();
	private String tur;
	protected String adi;
	private String girilenSecenek;
	public String cvp;
	protected Soru s;
	
	public Sinav( ){
	
	}
	
	public String getAdi() {
	return adi;
	}
	public void setAdi(String adi) {
	this.adi = adi;
	}
	public void soruEkle(Soru s){
	sorular.add(s);
	}
	public void soruSil(Soru s){
	sorular.remove(s);
	}
	
	public abstract void soruAra (String arama) ;

	public abstract void SinavOlustur(Soru s);
}
	


