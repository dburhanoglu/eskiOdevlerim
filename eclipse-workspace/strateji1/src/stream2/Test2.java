package stream2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import java.util.Vector;

public class Test2 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Ogrenci o1=new Ogrenci("berkay",123);
				Ogrenci o2=new Ogrenci("emine",333);
				Ogrenci o3=new Ogrenci("gamze",13);
				
				Vector<Ogrenci>ogrenciler=new Vector<>();
				ogrenciler.add(o1);
				ogrenciler.add(o2);
				ogrenciler.add(o3);
				
				try {
					FileInputStream fis=new FileInputStream("ogrenciler.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);
		Vector<Ogrenci> yeni;
		try {
			yeni = (Vector<Ogrenci>)ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				for(Ogrenci ogrenci:yeni) {
					System.out.println(ogrenci);
					
				}
					ois.close();
					 
					
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
