package aggcompozisyondene;

public class OgretimUyesi {
	private String adi;

	public OgretimUyesi() {
		adi = "";                   //2constructor var biri parametreli
	}

	public OgretimUyesi(String ad) {
		adi = ad;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@Override
	public String toString() {
		return "OgretimUyesi [adi=" + adi + "]";
	}

}
