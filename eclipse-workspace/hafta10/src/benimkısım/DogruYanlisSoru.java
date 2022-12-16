package benimkýsým;

import hocanýnseysi.Soru;

public class DogruYanlisSoru extends Soru{
public DogruYanlisSoru(String ad, String dAdi) {
		super(ad, dAdi);
		// TODO Auto-generated constructor stub
	}
private boolean dogruMu;
public boolean isDogruMu() {
return dogruMu;
}
public void setDogruMu(boolean dogruMu) {
this.dogruMu = dogruMu;
}

}