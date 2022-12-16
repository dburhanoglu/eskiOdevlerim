package abininödev;

import java.util.Scanner;
import java.util.Vector;

public class BDSoru extends Soru {
	
	Scanner girilen = new Scanner(System.in);
	@Override
	protected void Soruekle() {
		System.out.println("BD soru metnini giriniz::");
		metin=girilen.nextLine();
		
		System.out.println("BD soru puanýný giriniz::");
		puan=girilen.nextInt();
		System.out.println("BD soru zorluk giriniz::  KOLAY:0>>>NORMAL:1>>>>ZOR:2");
		zorluk=girilen.nextInt();
		
		
	}
	@Override
	protected void SinavOlustur() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	protected void SoruAra() {
		// TODO Auto-generated method stub
		
	}
*/

	





	
}
