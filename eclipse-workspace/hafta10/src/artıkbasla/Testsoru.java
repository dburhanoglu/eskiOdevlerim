package art�kbasla;

import java.util.Scanner;
import java.util.Vector;

public class Testsoru extends Soru   {
	Vector<String> testsorular=new Vector();
Vector<Integer>testzorluklar=new Vector();
Vector<Integer>testpuanlar=new Vector();
Vector<Integer,Integer>tests�klar=new Vector();

	@Override
	public void Soruekle() {

		System.out.println("ka� soru girmek istersiniz");
		Scanner klavye1=new Scanner(System.in);
		int girilen1 =klavye1.nextInt();
		
		for(int i=0;i<girilen1;i++)
		{//BURDA SADECE SORU ZORLUK VE PAUN G�RD�K �IKLAR YOK
			System.out.println("soru giriniz");
		   Scanner klavye2=new Scanner(System.in);
		   String girilen2=klavye2.nextLine();
		   testsorular.add(girilen2);
		 	System.out.println("�imdi de zorlu�unu girin 1 kolay 2 orta 3 zor");
		 	Scanner klavye3=new Scanner(System.in);
	 		int girilen3=klavye3.nextInt();
	 		testzorluklar.add(girilen3);
            System.out.println("�imdi de bu sorunun puan�n� giriniz 5 10 veya 20 giriniz");
            Scanner klavye4=new Scanner(System.in);
            int girilen4=klavye4.nextInt();
            testpuanlar.add(girilen4);
	    }
	    System.out.println("test soru girme i�lemi tamamland�");
		System.out.println(testsorular);
	    System.out.println(testzorluklar);
	    System.out.println(testpuanlar);
		
	}

	@Override
	public void Sorusil() {
	//buras�SADECEmetin icerisinde kelime aray�p siliyor
		int j;
	     System.out.println("silmek istedi�iniz soru metninde ge�en kelimeyi giriniz");
	     Scanner klavye5=new Scanner(System.in);
	     String girilen5=klavye5.nextLine();
	    for( j=0;j<testsorular.size();j++) {
		boolean b=testsorular.get(j).contains(girilen5);
		if(b==true) 
		{
		 System.out.println(testsorular.get(j)+"\tbunu sileyim mi?cevab�n evetse 1 e bas yoksa baska bir tu�a basabilirsin");
		 Scanner klavye6=new Scanner(System.in);
		  int c=klavye6.nextInt();
		   if(c==1)
			testsorular.set(j,null);
		   else
			continue;
		}				
	}
	
	System.out.println(testsorular);
	}

	@Override
	protected void zorluklistele() {System.out.println("zordan kolaya listeleyelim");
	for(int i=0;i<testzorluklar.size();i++){
		if(testzorluklar.get(i)==3) {
			System.out.println("i�te zor sorular");
			System.out.println(testsorular.get(i));
		}}
		for(int j=0;j<testzorluklar.size();j++){
			if(testzorluklar.get(j)==2) {
				System.out.println("i�te orta sorular");
				System.out.println(testsorular.get(j));
			}}
			for(int k=0;k<testzorluklar.size();k++){
				if(testzorluklar.get(k)==1) {
					System.out.println("i�te kolay sorular");
					System.out.println(testsorular.get(k));
				}}
		
		
	}

	@Override
	protected void puanlistele() {
		System.out.println("y�ksek puandan alcaga do�ru  listeleyelim");
		for(int i=0;i<testpuanlar.size();i++){
			if(testpuanlar.get(i)==20) {
				System.out.println("i�te 20 puanl�k sorular");
				System.out.println(testsorular.get(i));
			}}
		
		for(int j=0;j<testpuanlar.size();j++){
			if(testpuanlar.get(j)==10) {          ///NOTTTTTTTTTTT BURALARDA �F ELSE YAP 
				System.out.println("i�te 10 puanl�k sorular");
				System.out.println(testsorular.get(j));
			}}
	
		for(int k=0;k<testpuanlar.size();k++){
			if(testpuanlar.get(k)==5) {
				System.out.println("i�te 5 puanl�k sorular");
				System.out.println(testsorular.get(k));
			}}
		
	}

	@Override
	public void Metinicerenlistele() {
		System.out.println("hangi kelimenin ge�ti�i sorular� listeleyelim?l�tfen kelimeyi giriniz");
		Scanner klavye=new Scanner(System.in);
		String kelime=klavye.nextLine();
		for(int i=0;i<testsorular.size();i++) {
			boolean b=testsorular.get(i).contains(kelime);
			if(b==true)
		System.out.println(testsorular.get(i));
		}
		
		
	}


	/*@Override
	protected void dogrucevap() {
		// TODO Auto-generated method stub
		
	}
*/
	



	

	

}
