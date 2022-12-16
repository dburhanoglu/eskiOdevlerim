package asýl;

public abstract  class Calisan {
protected String adi;


public Calisan(String adi) {
	this.adi=adi;
	
}
public String getAdi() {
	return adi;
}
public void setAdi(String adi) {
	this.adi=adi;
}
public abstract double getMaas();}