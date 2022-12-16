package stream;
import java.io.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*try {
	FileWriter fw=new FileWriter("a.txt");
	fw.write("ali veli");
	fw.close();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try {
	FileReader fr=new FileReader("a.txt");
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	*/try {
		FileOutputStream fos=new FileOutputStream("a.dat");
		DataOutputStream dos=new DataOutputStream(fos);
		dos.writeDouble(3.6);dos.writeInt(1212);
		
		dos.writeUTF("ahmet mehmet");
		dos.close();
		DataInputStream dis=new DataInputStream(new FileInputStream("a.dat"));
			double d=dis.readDouble();int i=dis.readInt();
	
		System.out.println("integ"+i+""+d);
		dis.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	}


