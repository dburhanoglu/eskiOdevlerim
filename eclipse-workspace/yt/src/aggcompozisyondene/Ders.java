package aggcompozisyondene;

public class Ders {
	private String adi;
	private OgretimUyesi hoca;
	private Vector<Ogrenci> ogrenciler;
	
	public Ders(String ad) {
		adi = ad;
		hoca = null;
		ogrenciler = new Vector<Ogrenci>();
	}
	
	public Ders(String ad, OgretimUyesi h) {
		adi = ad;
		hoca = h;
		ogrenciler = new Vector<Ogrenci>();
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public OgretimUyesi getHoca() {
		return hoca;
	}

	public void setHoca(OgretimUyesi hoca) {
		this.hoca = hoca;
	}
	
	public void ugrencileriListele() {
		if(ogrenciler.size() == 0)
			System.out.println("Bu dersi alan öðrenci bulunmamaktadýr");
		else {
			System.out.println("---- Dersi Alan Öðrenciler ----");
			for (Ogrenci ogrenci : ogrenciler) {
				System.out.println(ogrenci);
			}
		}
	}
	
	public Ogrenci getOgrenciKayitSirasinaGore(int index) {
		if(index >= ogrenciler.size() || index < 0) return null;
		return ogrenciler.get(index);
	}
	
	public void ogrenciEkle(Ogrenci ogr) {
		ogrenciler.add(ogr);
	}
	
}
