package streamogren;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
public class Test {

	public static void main(String[] args) {
		try {
			System.setErr(new PrintStream("error.txt"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Scanner s = new Scanner(System.in);
	/*	
		System.out.print("Adi: ");
		try {
			String ad = br.readLine();
			System.out.print("No: ");
			int no = s.nextInt();
			//int no = Integer.parseInt(sno);
			System.out.println("ad: "+ad+"  no: "+no);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		Ogrenci o1 = new Ogrenci("Berkay", 123);
		Ogrenci o2 = new Ogrenci("Emine", 467);
		Ogrenci o3 = new Ogrenci("Gamze",545);
		Vector<Ogrenci> ogrenciler = new Vector<>();
		ogrenciler.add(o1);
		ogrenciler.add(o2);
		ogrenciler.add(o3);
		try {
			
			FileInputStream fis = new FileInputStream("ogrencier.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Vector<Ogrenci> yeni = (Vector<Ogrenci>)ois.readObject();
			for (Ogrenci ogrenci : yeni) {
				System.out.println(ogrenci);
			}
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

