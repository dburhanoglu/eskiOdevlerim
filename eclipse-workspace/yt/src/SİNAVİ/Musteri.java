package SİNAVİ;

public class Musteri {
private String adi;
private Hesap hesap;
public  Musteri(String ad,Hesap h) {//void olmayabilir
	this.adi=ad;
	hesap=h;
	
}	
	
	
public int getHesapNo(Hesap hesap) {
this.hesap=hesap;
return 0;
	}
public Hesap getHesap() {
	return hesap;
}
public void setHesap(Hesap hesap) {
	this.hesap = hesap;
}

	
	

}
