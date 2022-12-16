package benimkýsým;

import hocanýnseysi.Sorubank;

public abstract class Sorucl extends Sorubank{
	protected int puan;
	protected String metin;
	protected int zorluk;
	public static final int KOLAY=0;
	public static final int ORTA=1;
	public static final int ZOR=1;
	public abstract int getZorluk();
	public abstract void setZorluk(int zorluk);
	public abstract int getpuan();
	public abstract void setpuan(int zorluk);
	public abstract String getMetin();
	public abstract void setMetin(String metin);
	
}
