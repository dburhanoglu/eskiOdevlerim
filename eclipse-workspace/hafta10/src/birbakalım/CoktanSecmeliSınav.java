package birbakal?m;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CoktanSecmeliS?nav {
	static Scanner konsol = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("L?tfen ge?erli bir mail adresi giriniz.");
		String mailAdresi = konsol.nextLine();

		File dosya = new File("sinavsorulari.csv");
		Scanner s = new Scanner(dosya);

		// sorular? alma k?sm?
		String[] sorular = new String[10];
		int i = 0;
		while (s.hasNextLine()) {
			String satir = s.nextLine();
			sorular[i] = satir;
			i++;
		}
		s.close();

		sorular = shuffleArray(sorular);

		int dogruSayisi = 0;
		for (int j = 0; j < sorular.length; j++) {
			String[] split = sorular[j].split(";");
			System.out.println("Soru " + (j + 1) + ": " + split[0]);

			String s?klar = "";
			s?klar += "A) " + split[1] + " B) " + split[2];
			if (!split[3].equals("")) {
				s?klar += " C) " + split[3];
			}

			if (!split[4].equals("")) {
				s?klar += " D) " + split[4];
			}

			System.out.println(s?klar);

			String cevap = konsol.nextLine();
			if (cevap.equals(split[5])) {
				System.out.println("Dogru.");
				dogruSayisi++;
			} else {
				System.out.println("Yanl??.");
			}
			System.out.println();
		}
		dosyayaYaz(mailAdresi, dogruSayisi);
	}

	// Implementing Fisher?Yates shuffle
	static String[] shuffleArray(String[] ar) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			String a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
		return ar;
	}

	public static void dosyayaYaz(String mailAdresi, int dogruSay?s?) throws IOException {
		Writer r = new FileWriter("denemeler.csv", true);
		r.write(mailAdresi + ";" + dogruSay?s? + "\n");
		r.close();
	}
}
