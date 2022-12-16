package aggcompozisyondene;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	static Scanner input = new Scanner(System.in);
	
	static Vector<OgretimUyesi> hocalar = new Vector<OgretimUyesi>();
	static Vector<Ogrenci> ogrenciler = new Vector<Ogrenci>();
	static Vector<Ders> dersler = new Vector<Ders>();
	
	static final int OGRENCIEKLE = 1;
	static final int HOCAEKLE = 2;
	static final int DERSEKLE = 3;
	static final int BOLUMEKLE = 4;
	static final int CIKIS = 5;
	public static void main(String[] args) {
		
		int secim = -1;
		
		do{
			secim = printMenu();
			
			switch(secim) {
			case OGRENCIEKLE: ogrenciIslemleri(); break;
			case HOCAEKLE: hocaIslemleri(); break;
			case DERSEKLE: dersIslemleri(); break;
			case BOLUMEKLE:	bolumIslemleri(); break;
			}
		}while(secim != CIKIS);
		
	}
	

	private static void bolumIslemleri() {
		// TODO Auto-generated method stub
		
	}


	private static void dersIslemleri() {
		// TODO Auto-generated method stub
		int secim = -1;
		do {
			System.out.println("------DERS ��LEMLER�--------");
			System.out.println("1. Ders Ekleme");
			System.out.println("2. Dersleri Listele");
			System.out.println("3. Ana men�ye d�n");
			System.out.print("Se�iminiz: ");
			secim = input.nextInt();
			
			switch(secim) {
			case 1: dersEklemeIslemi(); break;
			case 2: dersleriListele(); break;
			}
		}while(secim != 3);

	}


	private static void dersEklemeIslemi() {
		// TODO Auto-generated method stub
		
		System.out.print("Dersin ismini giriniz: ");
		String adi = input.next().trim();
		
		Ders ders = new Ders(adi);
		dersler.add(ders);
		
		System.out.print("Dersi veren hocay� eklemek ister misiniz? (E/H): ");
		String yanit = input.next().trim();
		
		if(yanit.equals("E") || yanit.equals("e")) {
			hocalariListe();
			
			System.out.print("Eklemek istedi�iniz hocan�n numaras�n� giriniz: ");
			int hno = input.nextInt();
			if(hno-1 >= 0 || hno-1 < hocalar.size() ) {
				ders.setHoca(hocalar.elementAt(hno-1));
				System.out.println(hocalar.elementAt(hno-1)+" hoca olarak eklendi");
			}
			else {System.out.println("Se�ti�iniz indekste bir hoca bulunamad�");}
		}
		
		do {
			System.out.print("Derse ��renci eklemek ister misiniz? (E/H): ");
			yanit = input.next().trim();
			
			if(yanit.equals("E") || yanit.equals("e")) {
				ogrencileriListele();
				
				System.out.print("Eklemek istedi�iniz ��rencinin no giriniz: ");
				int ogrno = input.nextInt();
				Ogrenci secilen = null;
				for (Ogrenci ogrenci : ogrenciler) {
					if(ogrenci.getNo() == ogrno) {
						secilen = ogrenci;
						break;
					}
				}
				if(secilen != null) {
					ders.ogrenciEkle(secilen);
					System.out.println(secilen + " ��renci derse eklendi");
				}
				else {System.out.println("Se�ti�iniz numaral� bir ��renci bulunamad�");}
			}
		}while(yanit.equals("E") || yanit.equals("e"));
	}


	private static void dersleriListele() {
		// TODO Auto-generated method stub
		for(int i= 0; i < dersler.size(); i++) {
			System.out.println(i+1+". "+dersler.get(i));
		}
	}


	private static void hocaIslemleri() {
		// TODO Auto-generated method stub
		// men�y� yazd�r�ld�
		int secim = -1;
		do {
			System.out.println("------HOCA ��LEMLER�--------");
			System.out.println("1. Hoca Ekle");
			System.out.println("2. Hocalar� Listele");
			System.out.println("3. Ana men�ye d�n");
			System.out.print("Se�iminiz: ");
			secim = input.nextInt();
			
			switch(secim) {
			case 1: hocaEklemeIslemi(); break;
			case 2: hocalariListe(); break;
			}
		}while(secim != 3);
	}


	private static void hocalariListe() {
		// TODO Auto-generated method stub
		for(int i= 0; i < hocalar.size(); i++) {
			System.out.println(i+1+". "+hocalar.get(i));
		}
	}


	private static void hocaEklemeIslemi() {
		// TODO Auto-generated method stub
		System.out.print("Hocan�n ismini giriniz: ");
		String adi = input.next().trim();
		
		OgretimUyesi hoca = new OgretimUyesi(adi);
		hocalar.add(hoca);
	}


	private static void ogrenciIslemleri() {
		// TODO Auto-generated method stub
		int secim = -1;
		do {
			System.out.println("------��RENC� ��LEMLER�--------");
			System.out.println("1. ��renci Ekle");
			System.out.println("2. ��rencileri Listele");
			System.out.println("3. Ana men�ye d�n");
			System.out.print("Se�iminiz: ");
			secim = input.nextInt();
			
			switch(secim) {
			case 1: ogrenciEklemeIslemi(); break;
			case 2: ogrencileriListele(); break;
			}
		}while(secim != 3);private static void ogrencileriListele() {
			// TODO Auto-generated method stub
			for(int i= 0; i < ogrenciler.size(); i++) {
				System.out.println(i+1+". "+ogrenciler.get(i));
			}
		}


		private static void ogrenciEklemeIslemi() {
			// TODO Auto-generated method stub
			System.out.print("��rencinin numaras�n� giriniz: ");
			int no = input.nextInt();
			
			System.out.print("��rencinin ismini giriniz: ");
			String adi = input.next().trim();
			
			Ogrenci ogr = new Ogrenci(no,adi);
			ogrenciler.add(ogr);
			
			System.out.print("Dan��man eklemek ister misiniz? (E/H): ");
			String yanit = input.next().trim();
			
			if(yanit.equals("E") || yanit.equals("e")) {
				hocalariListe();
				
				System.out.print("Eklemek istedi�iniz dan��man�n numaras�n� giriniz: ");
				int hno = input.nextInt();
				if(hno-1 >= 0 || hno-1 < hocalar.size() ) {
					ogr.setDanisman(hocalar.elementAt(hno-1));
					System.out.println(hocalar.elementAt(hno-1)+" dan��man olarak eklendi");
				}
				else {System.out.println("Se�ti�iniz indekste bir dan��man bulunamad�");}
			}
			
		}


		private static int printMenu() {
			// TODO Auto-generated method stub
			System.out.println("------MEN�--------");
			System.out.println("1. Ogrenci Ekle");
			System.out.println("2. O�retim �yesi Ekle");
			System.out.println("3. Ders Ekle");
			System.out.println("4. B�l�m Ekle");
			System.out.println("5. ��k��");
			System.out.print("Se�iminiz: ");
			int secim = input.nextInt();
			return secim;
		}
	
	}
}