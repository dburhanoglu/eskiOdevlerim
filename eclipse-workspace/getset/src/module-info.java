module getset {
public class gettersetter {
private int deger;
private string ad;
public int getdeger() {
	return deger;
	
}
public int setdeger;(int deger){
	this.deger=deger;
}
public String getad() {
	return ad;
}
public String  setad(String ad) {
	this.ad=ad;
}
public static void main(String[] args) {
	gettersetter n1=new gettersetter();
	n1.setad("memo");
	n1.setdeger("12");
	System.out.println(n1.getad());
	System.out.println(n1.getdeger());
}
}