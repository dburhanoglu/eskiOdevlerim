package as�l;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Departman d1=new Departman("B�LG��SLEM");
Muhendis m1=new Muhendis("ali vel,",20);
Muhendis m2=new Muhendis("ays fat,",15);
Mudur mudur=new Mudur(20,"abc abc");
Stajyer s=new  Stajyer("gariban stajer");
d1.calisanEkle(m1);
d1.calisanEkle(m2);
d1.calisanEkle(mudur);d1.calisanEkle(s);
System.out.println("toplam odenecek"+d1.aylikOdenenMaas());
Calisan calisan=d1.getCalisanAt(2);
if(calisan instanceof Muhendis) {
Muhendis m=(Muhendis)calisan;//bu hatay� yaparsan hatay� hemen veriyor kodu �al��t�r�nca veriyor
System.out.println("muhendis gun sayisi"+m.getGunSayisi());
	}
else if(calisan instanceof Mudur) {
Mudur m=(Mudur)calisan;//bu hatay� yaparsan hatay� hemen veriyor kodu �al��t�r�nca veriyor
System.out.println("mudur gun sayisi"+m.getGunSayisi());
	}
//o hatalar� direk g�remeyece�imizden if ile sa�lamas�n� yapark �l��t�rd�m
Stack stack=new Stack(10);

stack.push(m1);
stack.push(mudur);
stack.push(s);stack.push(d1);
stack.push(3.5);




}}
