package hopenihai;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Coktansecmelisoru extends Soru implements Comparable<Coktansecmelisoru>, Serializable {

	public Vector<Coktansecmelisoru> cssorular = new Vector<>();
	protected int puani;
	protected String siklari;
	protected String dogrusikki;
	protected int zorlugu;
	protected String metni;

	public Coktansecmelisoru(String metni, String siklari, String dogrusikki, int zorlugu, int puani) {
		this.metni = metni;
		this.siklari = siklari;
		this.dogrusikki = dogrusikki;
		this.zorlugu = zorlugu;
		this.puani = puani;

	}

	public int getPuani() {
		return puani;
	}

	public void setPuani(int puani) {
		this.puani = puani;
	}

	public String getSiklari() {
		return siklari;
	}

	public void setSiklari(String siklari) {
		this.siklari = siklari;
	}

	public String getDogrusikki() {
		return dogrusikki;
	}

	public void setDogrusikki(String dogrusikki) {
		this.dogrusikki = dogrusikki;
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

		System.out.println("kac test sorusu gireceksin?");
		Scanner kl3 = new Scanner(System.in);
		int kac = kl3.nextInt();
		for (int i = 0; i < kac; i++) {
			System.out.println(
					"s?ras?yla metin s?k dogrus?k zorluk(kolay i?in 0 orta i?in 1 zor i?in 2 girin) ve puan girin");
			Scanner kl2 = new Scanner(System.in);
			String metin = kl2.nextLine();
			String siklar = kl2.nextLine();
			String dogrusik = kl2.nextLine();
			int zorluk = kl2.nextInt();
			int puan = kl2.nextInt();
			cssorular.add(new Coktansecmelisoru(metin, siklar, dogrusik, zorluk, puan));
		}

	}

	@Override
	protected void soruSil() {
		int i;
		System.out.println("silmek istedi?iniz soruda ge?en kelimeyi giriniz");
		Scanner klavye5 = new Scanner(System.in);
		String girilen5 = klavye5.nextLine();
		for (i = 0; i < cssorular.size(); i++) {
			Boolean b = cssorular.get(i).getMetni().contains(girilen5);
			if (b == true) {
				System.out.println(cssorular.get(i)
						+ "\tbunu sileyim mi?cevab?n evetse 1 e bas yoksa baska bir tu?a basabilirsin");
				Scanner klavye6 = new Scanner(System.in);
				int c = klavye6.nextInt();
				if (c == 1)
					cssorular.set(i, null);
				else
					continue;
			}

		}

	}

	@Override
	protected void soruS?rala() {

		System.out.println("icinde hangi kelimenin gecti?i sorular? listeleyelim"); // soru metnine gore
		Scanner klavye = new Scanner(System.in);
		String kelime = klavye.nextLine();
		for (int i = 0; i < cssorular.size(); i++) {
			Boolean b = cssorular.get(i).getMetni().contains(kelime);
			if (b == true) {
				Collections.sort(cssorular);
				for (Coktansecmelisoru deger : cssorular) {

				}
				System.out.println(cssorular.get(i));
			}
		}

		System.out.println("cevab? hangi ??k olan sorular? listeleyelim listeleyeyim");// dogrusikka gore
		Scanner kl1 = new Scanner(System.in);
		String sikki = kl1.nextLine();
		for (int i = 0; i < cssorular.size(); i++) {
			if (sikki.equalsIgnoreCase(cssorular.get(i).getDogrusikki())) {
				Collections.sort(cssorular);
				for (Coktansecmelisoru deger : cssorular) {

				}
				System.out.println(cssorular.get(i));
			}
		}
		System.out.println("puan? kac olan sorular? listeleyelim sorular? listeleyelim listeleyeyim");// puana g?re
		Scanner kl2 = new Scanner(System.in);
		int puani = kl2.nextInt();
		for (int i = 0; i < cssorular.size(); i++) {
			if (puani == cssorular.get(i).getPuani()) {
				Collections.sort(cssorular);
				for (Coktansecmelisoru deger : cssorular) {

				}
				System.out.println(cssorular.get(i));
			}
		}
		System.out.println(" s?klar?nda hangi kelimenin gecti?i sorular? listeleyelim ");// siktakelime arama
		Scanner kl3 = new Scanner(System.in);
		String kelime2 = kl3.nextLine();
		for (int i = 0; i < cssorular.size(); i++) {
			Boolean a = cssorular.get(i).getSiklari().contains(kelime);

			if (a == true) {

				Collections.sort(cssorular);
				for (Coktansecmelisoru deger : cssorular) {

				}
				System.out.println(cssorular.get(i));
			}
		}

		System.out.println("zorluk derecesi ka? olan sorular? listeleyeyim");// zorluga g?re
		Scanner kl5 = new Scanner(System.in);
		int zorluk = kl5.nextInt();
		for (int i = 0; i < cssorular.size(); i++) {
			if (zorluk == cssorular.get(i).getZorlugu()) {
				Collections.sort(cssorular);
				for (Coktansecmelisoru deger : cssorular) {

				}
				System.out.println(cssorular.get(i));
			}
		}
	}

	@Override
	public int compareTo(Coktansecmelisoru o) {
		if (this.puani > o.puani)
			return 1;
		if (this.puani < o.puani)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return " metni: " + metni + " dogrucevabi " + siklari + "zorlugu " + zorlugu + "puani " + puani;
	}

	@Override
	protected void Sorukaristir() {

	}

}
