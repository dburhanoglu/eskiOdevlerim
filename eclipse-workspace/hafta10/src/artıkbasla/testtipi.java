package artıkbasla;

public class testtipi implements Comparable<testtipi>{
protected int puani;
protected String  siklari;
protected String dogrusikki;
protected int zorlugu;
protected String metni;
public testtipi(String metni,String siklari,String dogrusikki,int zorlugu,int puani) {
	this.metni=metni;
	this.siklari=siklari;
	this.dogrusikki=dogrusikki;
	this.zorlugu=zorlugu;
	this.puani=puani;
	
}

@Override
public int compareTo(testtipi o) {
	if(this.puani>o.puani) return 1;
	if(this.puani<o.puani) return -1;
	return 0;
}

@Override
public String toString() {
	return "testtipi: metni: "+metni+ " siklari: "+siklari
			+"zorlugu "+ zorlugu+"puani " + puani;
}






}
