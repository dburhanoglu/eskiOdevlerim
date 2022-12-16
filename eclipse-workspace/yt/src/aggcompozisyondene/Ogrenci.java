package aggcompozisyondene;

public class Ogrenci {
	private int no;
private String adi;

private OgretimUyesi danisman;
private OgrenciKarti kart;
public void Ogrenci(String adi,int no,OgretimUyesi d) {
	this.adi=adi;
	this.no=no;
	this.danisman=d;
	kart = new OgrenciKarti(no);
}
public void Ogrenci(String adi,int no) {
	this(no, adi, null);
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getAdi() {
	return adi;
}
public void setAdi(String adi) {
	this.adi = adi;
}
public OgretimUyesi getDanisman() {
	return danisman;
}
public void setDanisman(OgretimUyesi danisman) {
	this.danisman = danisman;
}
public OgrenciKarti getKart() {
	return kart;
}
public void setKart(OgrenciKarti kart) {
	this.kart = kart;
}
@Override
public String toString() {
	return "Ogrenci [no=" + no + ", adi=" + adi + ", danisman=" + danisman + ", kart=" + kart + "]";
}
}
