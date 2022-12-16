package hopenihai;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import hopenihai.Dysoru;

public class Bosluksoru extends Soru implements Comparable<Bosluksoru> {
	Vector<Bosluksoru> bossorular = new Vector<>();
	protected int puani;
	protected String dogrucevabi;
	protected int zorlugu;
	protected String metni;

	public Bosluksoru(String metni, String dogrucevabi, int zorlugu, int puani) {
		this.metni = metni;
		this.dogrucevabi = dogrucevabi;
		this.zorlugu = zorlugu;
		this.puani = puani;
	}

	public int getPuani() {
		return puani;
	}

	public void setPuani(int puani) {
		this.puani = puani;
	}

	public String getDogrucevabi() {
		return dogrucevabi;
	}

	public void setDogrucevabi(String dogrucevabi) {
		this.dogrucevabi = dogrucevabi;
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

		System.out.println("kac bosluk sorusu gireceksin?");
		Scanner kl90 = new Scanner(System.in);
		int kac2 = kl90.nextInt();
		for (int i = 0; i < kac2; i++) {
			System.out.println(
					"sýrasýyla metini doðru cevabi zorluk(kolay için 0 orta için 1 zor için 2 girin) ve puan  girin");
			Scanner kl9 = new Scanner(System.in);
			String metin2 = kl9.nextLine();
			String dogrucevap2 = kl9.nextLine();
			int zorluk2 = kl9.nextInt();
			int puan2 = kl9.nextInt();
			bossorular.add(new Bosluksoru(metin2, dogrucevap2, zorluk2, puan2));

		}

	}

	@Override
	protected void soruSil() {
		int i;
		System.out.println("silmek istediðiniz soruda geçen kelimeyi giriniz");
		Scanner klavye5 = new Scanner(System.in);
		String girilen5 = klavye5.nextLine();
		for (i = 0; i < bossorular.size(); i++) {
			Boolean b = bossorular.get(i).getMetni().contains(girilen5);
			if (b == true) {
				System.out.println(bossorular.get(i)
						+ "\tbunu sileyim mi?cevabýn evetse 1 e bas yoksa baska bir tuþa basabilirsin");
				Scanner klavye6 = new Scanner(System.in);
				int c = klavye6.nextInt();
				if (c == 1)
					bossorular.set(i, null);
				else
					continue;
			}
		}

	}

	@Override
	protected void soruSýrala() {
		System.out.println("icinde hangi kelimenin gectiði sorularý listeleyelim"); // soru metnine gore
		Scanner klavye = new Scanner(System.in);
		String kelime = klavye.nextLine();
		for (int i = 0; i < bossorular.size(); i++) {
			Boolean b = bossorular.get(i).getMetni().contains(kelime);
			if (b == true) {
				Collections.sort(bossorular);
				for (Bosluksoru degerbos : bossorular) {
				}
				System.out.println(bossorular.get(i));

			}
		}
		System.out.println("puaný kac olan sorularý listeleyelim sorularý listeleyelim listeleyeyim");// puana göre
		Scanner kl2 = new Scanner(System.in);
		int puani = kl2.nextInt();
		for (int i = 0; i < bossorular.size(); i++) {
			if (puani == bossorular.get(i).getPuani()) {
				Collections.sort(bossorular);
				for (Bosluksoru degerbos : bossorular) {

				}
				System.out.println(bossorular.get(i));
			}
		}
		System.out.println("zorluk derecesi kaç olan sorularý listeleyeyim");// zorluga göre
		Scanner kl5 = new Scanner(System.in);
		int zorluk = kl5.nextInt();
		for (int i = 0; i < bossorular.size(); i++) {
			if (zorluk == bossorular.get(i).getZorlugu()) {
				Collections.sort(bossorular);
				for (Bosluksoru degerdy : bossorular) {

				}
				System.out.println(bossorular.get(i));
			}
		}

		System.out.println("cevabý ne olan sorularý listeleyelim listeleyeyim");// dogrucevaba gore
		Scanner kln = new Scanner(System.in);
		String dogrucevap = kln.nextLine();
		for (int i = 0; i < bossorular.size(); i++) {
			if (dogrucevap.equalsIgnoreCase(bossorular.get(i).getDogrucevabi())) {
				Collections.sort(bossorular);
				for (Bosluksoru degerdy : bossorular) {

				}
				System.out.println(bossorular.get(i));
			}
		}

	}

	@Override
	public int compareTo(Bosluksoru b) {
		if (this.puani > b.puani)
			return 1;
		if (this.puani < b.puani)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return " metni: " + metni + " dogrucevabi " + dogrucevabi + "zorlugu " + zorlugu + "puani " + puani;
	}

	@Override
	protected void Sorukaristir() {
		// TODO Auto-generated method stub

	}
}
