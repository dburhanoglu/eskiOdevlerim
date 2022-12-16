package hopenihai;

public class Klasiksinav extends Sinav {
private String metin;
private int puan;
	public Klasiksinav(String metin, int puan) {
	super();
	this.metin = metin;
	this.puan = puan;
}
	public String getMetin() {
		return metin;
	}
	public void setMetin(String metin) {
		this.metin = metin;
	}
	public int getPuan() {
		return puan;
	}
	public void setPuan(int puan) {
		this.puan = puan;
	}
	@Override
	protected void SinavOlustur() {
		
		
	}

}
