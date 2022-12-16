package abininödev;

import java.util.Vector;

public class SoruBankasi extends Sinav {

	
	
	public SoruBankasi( ) {
		for (int i=0;i<sorular.size();i++) {
			
			
		System.out.println(sorular.get(i));
		
		}
	}
	
	
	public   void soruAra (String a) {
		
		for (int i=0;i<sorular.size();i++) {	
	boolean b=	sorular.get(i).getMetin().contains(a); 
	if (b==true) { System.out.println(sorular.get(i));}
		
		
		}
		
	}
	@Override
	public void SinavOlustur(Soru s) {
		// TODO Auto-generated method stub
		
	}




}
