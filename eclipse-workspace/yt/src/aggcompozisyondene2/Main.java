package aggcompozisyondene2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
OgretimUyesi o1=new OgretimUyesi("dogan ayd�n");
Ogrenci o2=new Ogrenci(111,"ali",o1);
Ogrenci o3=new Ogrenci(11234,"veli");
o3.setDanisman(o1);
//o1=null;
System.out.println(o3);
	}

	@Override
	public String toString() {
		return "Main []";
	}

}
