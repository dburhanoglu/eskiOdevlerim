package hocanýnseysi;

import java.util.Vector;

import benimkýsým.Derslik;


	public class Sinav {
		private Vector<Soru> sorular = new Vector();
		//private Derslik sinavYeri;
		private String adi;
		public Sinav( String ad){
		adi = ad;
		//sinavYeri = new Derslik(dAdi);
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
		}