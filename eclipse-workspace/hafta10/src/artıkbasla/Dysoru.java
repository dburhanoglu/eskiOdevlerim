package art�kbasla;

import java.util.Scanner;
import java.util.Vector;

public class Dysoru extends Soru  {
	Vector<String> dysorular=new Vector();
Vector<Integer>dyzorluklar=new Vector();
Vector<Integer>dypuanlar=new Vector();
		
	@Override
	public void Soruekle() {
		System.out.println("ka� soru girmek istersiniz");
		Scanner klavye1=new Scanner(System.in);
		int girilen1 =klavye1.nextInt();
		
		for(int i=0;i<girilen1;i++)
		{
			System.out.println("soru giriniz");
		   Scanner klavye2=new Scanner(System.in);
		   String girilen2=klavye2.nextLine();
		 dysorular.add(girilen2);
		 	System.out.println("�imdi de zorlu�unu girin 1 kolay 2 orta 3 zor");
		 	Scanner klavye3=new Scanner(System.in);
	 		int girilen3=klavye3.nextInt();
	 		dyzorluklar.add(girilen3);
            System.out.println("�imdi de bu sorunun puan�n� giriniz 5 10 veya 20 giriniz");
            Scanner klavye4=new Scanner(System.in);
            int girilen4=klavye4.nextInt();
            dypuanlar.add(girilen4);
	    }
	    System.out.println("do�ru-yanl�� soru girme i�lemi tamamland�");
		System.out.println(dysorular);
	    System.out.println(dyzorluklar);
	    System.out.println(dypuanlar);
		
	}

	@Override
	public void Sorusil() {
		int j;
	     System.out.println("silmek istedi�iniz soruda ge�en kelimeyi giriniz");
	     Scanner klavye5=new Scanner(System.in);
	     String girilen5=klavye5.nextLine();
	    for( j=0;j<dysorular.size();j++) {
		boolean b=dysorular.get(j).contains(girilen5);
		if(b==true) 
		{
		 System.out.println(dysorular.get(j)+"\tbunu sileyim mi?cevab�n evetse 1 e bas yoksa baska bir tu�a basabilirsin");
		 Scanner klavye6=new Scanner(System.in);
		  int c=klavye6.nextInt();
		   if(c==1)
			dysorular.set(j,null);
		   else
			continue;
		}				
	}
	
	System.out.println(dysorular);
		
	}

	@Override
	protected void zorluklistele() {
		System.out.println("zordan kolaya listeleyelim");
		for(int i=0;i<dyzorluklar.size();i++){
			if(dyzorluklar.get(i)==3) {
				System.out.println("i�te zor sorular");
				System.out.println(dysorular.get(i));
			}}
			for(int j=0;j<dyzorluklar.size();j++){
				if(dyzorluklar.get(j)==2) {
					System.out.println("i�te orta sorular");
					System.out.println(dysorular.get(j));
				}}
				for(int k=0;k<dyzorluklar.size();k++){
					if(dyzorluklar.get(k)==1) {
						System.out.println("i�te kolay sorular");
						System.out.println(dysorular.get(k));
					}}
		
	}

	@Override
	protected void puanlistele() {
		System.out.println("y�ksek puandan alcaga do�ru  listeleyelim");
		for(int i=0;i<dypuanlar.size();i++){
			if(dypuanlar.get(i)==20) {
				System.out.println("i�te 20 puanl�k sorular");
				System.out.println(dysorular.get(i));
			}}
		
		for(int j=0;j<dypuanlar.size();j++){
			if(dypuanlar.get(j)==10) {          ///NOTTTTTTTTTTT BURALARDA �F ELSE YAP 
				System.out.println("i�te 10 puanl�k sorular");
				System.out.println(dysorular.get(j));
			}}
	
		for(int k=0;k<dypuanlar.size();k++){
			if(dypuanlar.get(k)==5) {
				System.out.println("i�te 5 puanl�k sorular");
				System.out.println(dysorular.get(k));
			}}
		
	}

	@Override
	public void Metinicerenlistele() {
		System.out.println("hangi kelimenin ge�ti�i sorular� listeleyelim?l�tfen kelimeyi giriniz");
		Scanner klavye=new Scanner(System.in);
		String kelime=klavye.nextLine();
		for(int i=0;i<dysorular.size();i++) {
			boolean b=dysorular.get(i).contains(kelime);
			if(b==true)
		System.out.println(dysorular.get(i));
		}
		
		
		
		
	}
		
	

	
	
/*
	@Override
	protected void dogrucevap() {
		// TODO Auto-generated method stub
		
	}*/


	
	

}
