package youtube;
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.logging.Level;



import java.util.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtOkuma {

	public static void main(String[] args) {
		File dosya = new File("dosya.txt");
		if (!dosya.exists()) {
			try {
				dosya.createNewFile();
			}catch(IOException ex) {
			}
		}else {
			try {
				Scanner s=new Scanner(dosya);
			/*	while(s.hasNextLine()) {
					String satir=s.nextLine();
				//System.out.println(satir);
				String[] split=satir.split(";");
				for(int i=0;i<split.length;i++) {
					//System.out.println(split[i]+"");
					
				}System.out.println(split[0]);//burda split[0] ý bastýr dediðimde
		
			
			*/}s.close();
			
			}catch(FileNotFoundException ex) {
	//}}
}}