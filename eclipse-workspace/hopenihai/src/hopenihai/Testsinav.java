package hopenihai;

import java.io.Serializable;
import java.util.Vector;

public class Testsinav extends Sinav implements Serializable, NotHesaplanabilme {

	public Testsinav(int puani2, String siklari1, String metni1) {
		super();
		this.puani2 = puani2;
		this.siklari1 = siklari1;
		this.metni1 = metni1;
	}

	private int puani2;
	private String siklari1;
	private String metni1;

	public int getPuani2() {
		return puani2;
	}

	public void setPuani2(int puani2) {
		this.puani2 = puani2;
	}

	public String getSiklari1() {
		return siklari1;
	}

	public void setSiklari1(String siklari1) {
		this.siklari1 = siklari1;
	}

	public String getMetni1() {
		return metni1;
	}

	public void setMetni1(String metni1) {
		this.metni1 = metni1;
	}

	@Override
	public void notHesapla() {// Hocam bu kýsým yapmak istediðimiz fakat gerekli ayarlamalarý yapamadýðýmýzdan
		// calismaz halde yazdýðýmýz bir metot
		/*
		 * for(int i=0;i<cssorular.size();i++) { if(boolean cevap==true;) { int
		 * dogruPuan=cssorular.get(i).getPuan; } else int
		 * yanlisPuan=cssorular.get(i).getPuan();
		 * 
		 * } int notu= (100*dogruPuan)/(dogruPuan+yanlisPuan); System.out.println(notu);
		 * }
		 */
	}

	@Override
	protected void SinavOlustur() {

	}

}
