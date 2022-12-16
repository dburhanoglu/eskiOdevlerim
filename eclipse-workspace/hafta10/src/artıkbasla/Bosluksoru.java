package art�kbasla;

import java.util.Scanner;
import java.util.Vector;

public class Bosluksoru extends Soru {
	Vector<String> bosluksorular=new Vector();
	Vector<String>boslukcevaplar=new Vector();
	Vector<Integer>boslukzorluklar=new Vector();
	Vector<Integer>boslukpuanlar=new Vector();

	@Override
	public void Soruekle() {
		

		System.out.println("ka� soru girmek istersiniz");
		Scanner klavye1=new Scanner(System.in);
		int girilen1 =klavye1.nextInt();
		for(int i=0;i<girilen1;i++)
		{ 
			System.out.println("soru  giriniz");
			 Scanner klavye2=new Scanner(System.in);
		    String girilen2=klavye2.nextLine();
		    bosluksorular.add(girilen2);
		    System.out.println("cevab�n� giriniz");
		     Scanner klavye3=new Scanner(System.in);
		     String girilen3=klavye3.nextLine();
		     boslukcevaplar.add(girilen3);
		     System.out.println("�imdi de zorlu�unu girin 1 kolay 2 orta 3 zor");
			 	Scanner klavye4=new Scanner(System.in);
		 		int girilen4=klavye4.nextInt();
		 		boslukzorluklar.add(girilen4);
	            System.out.println("�imdi de bu sorunun puan�n� giriniz");
	            Scanner klavye5=new Scanner(System.in);
	            int girilen5=klavye5.nextInt();
	            boslukpuanlar.add(girilen5);
		
		
		}
		System.out.println(bosluksorular);
		System.out.println(boslukcevaplar);
		System.out.println(boslukzorluklar);
		System.out.println(boslukpuanlar);
		
	}

	@Override
	public void Sorusil() {
		int j;
		System.out.println("silmek istedi�iniz soruda ge�en kelimeyi giriniz");
		Scanner klavye5=new Scanner(System.in);
		String girilen5=klavye5.nextLine();
		for( j=0;j<bosluksorular.size();j++) {
			boolean b=bosluksorular.get(j).contains(girilen5);
			if(b==true) {
				System.out.println(bosluksorular.get(j)+"\tbunu sileyim mi?cevab�n evetse 1 e bas yoksa baska bir tu�a basabilirsin");
			Scanner klavye6=new Scanner(System.in);
			int c=klavye6.nextInt();
			if(c==1)
				bosluksorular.set(j,null);
			else
				continue;
			}
			 }
							
		System.out.println(bosluksorular);
	}

	@Override
	protected void zorluklistele() {
		System.out.println("zordan kolaya listeleyelim");
		for(int i=0;i<bosluksorular.size();i++){
			if(boslukzorluklar.get(i)==3) {
				System.out.println("i�te zor sorular");
				System.out.println(bosluksorular.get(i));
			}}
			for(int j=0;j<bosluksorular.size();j++){
				if(boslukzorluklar.get(j)==2) {
					System.out.println("i�te orta sorular");
					System.out.println(bosluksorular.get(j));
				}}
				for(int k=0;k<bosluksorular.size();k++){
					if(boslukzorluklar.get(k)==1) {
						System.out.println("i�te kolay sorular");
						System.out.println(bosluksorular.get(k));
					}}
		
	}

	@Override
	protected void puanlistele() {
		System.out.println("y�ksek puandan alcaga do�ru  listeleyelim");
		for(int i=0;i<boslukpuanlar.size();i++){
			if(boslukpuanlar.get(i)==20) {
				System.out.println("i�te 20 puanl�k sorular");
				System.out.println(bosluksorular.get(i));
			}}
		
		for(int j=0;j<boslukpuanlar.size();j++){
			if(boslukpuanlar.get(j)==10) {          ///NOTTTTTTTTTTT BURALARDA �F ELSE YAP 
				System.out.println("i�te 10 puanl�k sorular");
				System.out.println(bosluksorular.get(j));
			}}
	
		for(int k=0;k<boslukpuanlar.size();k++){
			if(boslukpuanlar.get(k)==5) {
				System.out.println("i�te 5 puanl�k sorular");
				System.out.println(bosluksorular.get(k));
			}}
		
		
	}

	@Override
	public void Metinicerenlistele() {
		System.out.println("hangi kelimenin ge�ti�i sorular� listeleyelim?l�tfen kelimeyi giriniz");
		Scanner klavye=new Scanner(System.in);
		String kelime=klavye.nextLine();
		for(int i=0;i<bosluksorular.size();i++) {
			boolean b=bosluksorular.get(i).contains(kelime);
			if(b==true)
		System.out.println(bosluksorular.get(i));
		}
		
	}


	/*@Override
	protected void dogrucevap() {
		System.out.println("ka��nc� sorunun cevab�n� istiyorsun?");
			Scanner klavye4=new Scanner(System.in);
		int girilen4=klavye4.nextInt();
			System.out.println(boslukcevaplar.get(girilen4-1));
			
		
		
	}*/

	
	
}
