package asýl;

public abstract class TamZamanli extends Calisan  {
	protected int gunSayisi;
	public TamZamanli(int gunS,String adi) {
		super(adi);
		gunSayisi=gunS;
		
	}
	
public int getGunSayisi()
{
	return gunSayisi;
}
public void setGunSayisi(int gunSayisi) {
	this.gunSayisi=gunSayisi;

}
}
