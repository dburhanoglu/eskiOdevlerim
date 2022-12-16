package aggcompozisyondene;
import java.util.Vector;

public class Bolum {
	private String adi;
	private Vector<Ders> dersler;
	private Vector<OgretimUyesi> hocalar;
	public Bolum(String adi) {
		dersler = new Vector<Ders>();
		hocalar = new Vector<OgretimUyesi>();
		this.adi = adi;
	}
	
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	
	public void dersEkle(Ders d) {
		dersler.add(d);
	}
	
	public void dersCikar(Ders d) {
		dersler.remove(d);
	}
	
	public void hocaEkle(OgretimUyesi o) {
		hocalar.add(o);
	}
	
	public void hocaCikar(OgretimUyesi o) {
		hocalar.remove(o);
	}
	
	public OgretimUyesi hocaGetir(int index) {
		if(index >= hocalar.size() || index < 0) return null;
		return hocalar.elementAt(index);
	}
	
	public String toString() {
		return "Bölüm Adý: "+ adi + 
				"\t Müfredattaki Ders Sayýsý: "+ dersler.size()+
				"\t Hoca sayýsý: "+ hocalar.size();
	}
	
}
