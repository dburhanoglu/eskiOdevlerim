package hopenihai;

public class Karisiksinav extends Sinav{
private String metni;
private String siklari;
private int Puani;
	public Karisiksinav(String metni, String siklari, int puani) {
	super();
	this.metni = metni;
	this.siklari = siklari;
	Puani = puani;
}
	public String getMetni() {
		return metni;
	}
	public void setMetni(String metni) {
		this.metni = metni;
	}
	public String getSiklari() {
		return siklari;
	}
	public void setSiklari(String siklari) {
		this.siklari = siklari;
	}
	public int getPuani() {
		return Puani;
	}
	public void setPuani(int puani) {
		Puani = puani;
	}
	@Override
	protected void SinavOlustur() {
	
	
		
	}

}
