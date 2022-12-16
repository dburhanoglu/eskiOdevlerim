package strateji1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KirmiziOrdek ordek=new KirmiziOrdek();
		ordek.ot();
		ordek.uc();
		
		
		ordek.setUcabilme(new Ucamama());//runtimeda  kýrmýzý ordeðin ucabilme ozelliðini deðiþtirmek için
		ordek.uc();
		ordek.setOtebilme(new VikVik());
ordek.ot();
	}

}
