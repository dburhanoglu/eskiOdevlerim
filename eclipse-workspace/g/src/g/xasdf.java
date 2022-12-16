import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DosyadanOku {

    public static void main(String[] args) throws IOException {

        File file = new File("graf.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();

            while (satir!=null) {
            	System.out.println(satir);
                satir = reader.readLine();
            }

		}}

