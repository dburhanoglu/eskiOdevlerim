package k;


	
	public class gettersetter {
	private int deger;
	private String ad;
	public int getdeger() {
		return deger;
		
	}
	public int setDeger(int deger){
		this.deger=deger;
	}
	//public String getad() {
		return ad;
	}
//	public String  setAd(String ad) {
		this.ad=ad;
	}
	public static void main(String[] args) {
		gettersetter n1=new gettersetter();
	//	n1.setAd("memo");
		n1.setDeger("12");
	//	System.out.println(n1.getad());
		System.out.println(n1.getdeger());
	}
}
