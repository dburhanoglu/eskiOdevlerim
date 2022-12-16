package asýl;

import java.util.Vector;

public class Departman {
	private String ad;
private Vector<Calisan> calisanlar;
public Departman(String adi) {
	this.ad=adi;
	calisanlar=new Vector<Calisan>(15,5);
	
}public void calisanEkle(Calisan c) {
	calisanlar.add(c);

}public double  aylikOdenenMaas() {
	double toplam =0.0;
	for(Calisan calisan :calisanlar) {
		toplam+=calisan.getMaas();
		
	}
	return toplam;
}
public Calisan getCalisanAt(int index) {
	if(index>0 &&index<calisanlar.size()) {
		return calisanlar.get(index);
		
	}
	return null;
}
}