package asıl;

public class Muhendis extends TamZamanli {
	public Muhendis(String adi,int gs) {
		super(gs,adi);
	}
public Muhendis(String adi) {
	super(0,adi);
	
}
public double getMaas() {
	return gunSayisi*400;
}
public String getAdi() {
	return "müh."+adi;
			
}
}
