package abininödev;

import java.util.Scanner;

public class TestSinav extends Sinav {



		public  void SinavOlustur(Soru cs) {
			for (int i=0;i<=sorular.size();i++) {	
			System.out.println(sorular.get(i).getMetin());
			System.out.println("Cevabýnýz::");
			sorular.get(i).cvp= girilen.nextLine();
			}

		}

		@Override
		public void soruAra(String arama) {
			// TODO Auto-generated method stub
			
		} }


