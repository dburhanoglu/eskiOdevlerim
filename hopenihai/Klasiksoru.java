package hopenihai;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import hopenihai.Dysoru;

public class Klasiksoru extends Soru implements Comparable<Klasiksoru> {
	Vector<Klasiksoru> klasiksorular = new Vector<>();
	protected int puani;

	protected int zorlugu;
	protected String metni;

	public Klasiksoru(String metni, int zorlugu, int puani) {
		this.metni = metni;
		this.zorlugu = zorlugu;
		this.puani = puani;
	}

	public int getPuani() {
		return puani;
	}

	public void setPuani(int puani) {
		this.puani = puani;
	}

	public int getZorlugu() {
		return zorlugu;
	}

	public void setZorlugu(int zorlugu) {
		this.zorlugu = zorlugu;
	}

	public String getMetni() {
		return metni;
	}

	public void setMetni(String metni) {
		this.metni = metni;
	}

	@Override
	protected void soruEkle() {
		System.out.println("kac klasik sorusu gireceksin?");
		Scanner kl90 = new Scanner(System.in);
		int kac2 = kl90.nextInt();
		for (int i = 0; i < kac2; i++) {
			System.out.println("s�ras�yla metin zorluk(kolay i�in 0 orta i�in 1 zor i�in 2 girin) ve puan  girin");
			Scanner kl9 = new Scanner(System.in);
			String metin2 = kl9.nextLine();
			int zorluk2 = kl9.nextInt();
			int puan2 = kl9.nextInt();
			klasiksorular.add(new Klasiksoru(metin2, zorluk2, puan2));

		}

	}

	@Override
	protected void soruSil() {
		int i;
		System.out.println("silmek istedi�iniz soruda ge�en kelimeyi giriniz");
		Scanner klavye5 = new Scanner(System.in);
		String girilen5 = klavye5.nextLine();
		for (i = 0; i < klasiksorular.size(); i++) {
			Boolean b = klasiksorular.get(i).getMetni().contains(girilen5);
			if (b == true) {
				System.out.println(klasiksorular.get(i)
						+ "\tbunu sileyim mi?cevab�n evetse 1 e bas yoksa baska bir tu�a basabilirsin");
				Scanner klavye6 = new Scanner(System.in);
				int c = klavye6.nextInt();
				if (c == 1)
					klasiksorular.set(i, null);
				else
					continue;
			}
			
		}

		

	}

	@Override
	protected void soruS�rala() {
		System.out.println("icinde hangi kelimenin gecti�i sorular� listeleyelim?"); // soru metnine gore
		Scanner klavye = new Scanner(System.in);
		String kelime = klavye.nextLine();
		for (int i = 0; i < klasiksorular.size(); i++) {
			Boolean b = klasiksorular.get(i).getMetni().contains(kelime);
			if (b == true) {
				Collections.sort(klasiksorular);
				for (Klasiksoru degerbos : klasiksorular) {
					
				}System.out.println(klasiksorular.get(i));
			}
		}

		System.out.println("puan� kac olan sorular� listeleyelim sorular� listeleyelim listeleyeyim?");// puana g�re
		Scanner kl2 = new Scanner(System.in);
		int puani = kl2.nextInt();
		for (int i = 0; i < klasiksorular.size(); i++) {
			if (puani == klasiksorular.get(i).getPuani()) {
				Collections.sort(klasiksorular);
				for (Klasiksoru degerbos : klasiksorular) {
					
				}System.out.println(klasiksorular.get(i));
			}
		}
		System.out.println("zorluk derecesi ka� olan sorular� listeleyeyim");// zorluga g�re
		Scanner kl5 = new Scanner(System.in);
		int zorluk = kl5.nextInt();
		for (int i = 0; i < klasiksorular.size(); i++) {
			if (zorluk == klasiksorular.get(i).getZorlugu()) {
				Collections.sort(klasiksorular);
				for (Klasiksoru degerdy : klasiksorular) {
				}System.out.println(klasiksorular.get(i));
			}
		}
					

	}

	@Override
	public int compareTo(Klasiksoru k) {
		if (this.puani > k.puani)
			return 1;
		if (this.puani < k.puani)
			return -1;
		return 0;
	}

	public String toString() {
		return " metni: " + metni + "zorlugu " + zorlugu + "puani " + puani;
	}

	@Override
	protected void Sorukaristir() {
		// TODO Auto-generated method stub

	}

}