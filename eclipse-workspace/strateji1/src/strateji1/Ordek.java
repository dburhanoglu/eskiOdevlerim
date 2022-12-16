package strateji1;

public abstract class Ordek {
	protected Ucabilme ucma;
	protected Otebilme otme;
	public Ordek(Otebilme otme,Ucabilme ucma)
	{
		this.otme=otme;
		this.ucma=ucma;
		
	}
	public void setOtebilme(Otebilme tip) {
		otme=tip;
	}
public void setUcabilme(Ucabilme tip) {
	ucma=tip;
}
public void uc() {ucma.uc();}
public void ot() {otme.ot();}
public abstract void ciz();

}