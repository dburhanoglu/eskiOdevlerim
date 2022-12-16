



package degisim;


import java.util.Scanner;
import java.util.Vector;

import artýkbasla.Klasiksoru;
import artýkbasla.Soru;

public class Bosluksoru extends Soru 
{
	Vector<String> bosluksorular=new Vector();
	Vector<String>boslukcevaplar=new Vector();
	Vector<Integer>boslukzorluklar=new Vector();
	Vector<Integer>boslukpuanlar=new Vector();

	@Override
	public void Soruekle() {
		

		System.out.println("kaç soru girmek istersiniz");
		Scanner klavye1=new Scanner(System.in);
		int girilen1 =klavye1.nextInt();
		for(int i=0;i<girilen1;i++)
		{ 
			System.out.println("soru  giriniz");
			 Scanner klavye2=new Scanner(System.in);
		    String girilen2=klavye2.nextLine();
		    bosluksorular.add(girilen2);
		    System.out.println("cevabýný giriniz");
		     Scanner klavye3=new Scanner(System.in);
		     String girilen3=klavye3.nextLine();
		     boslukcevaplar.add(girilen3);
		     System.out.println("þimdi de zorluðunu girin 1 kolay 2 orta 3 zor");
			 	Scanner klavye4=new Scanner(System.in);
		 		int girilen4=klavye4.nextInt();
		 		boslukzorluklar.add(girilen4);
	            System.out.println("þimdi de bu sorunun puanýný giriniz");
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
		System.out.println("silmek istediðiniz soruda geçen kelimeyi giriniz");
		Scanner klavye5=new Scanner(System.in);
		String girilen5=klavye5.nextLine();
		for( j=0;j<bosluksorular.size();j++) {
			boolean b=bosluksorular.get(j).contains(girilen5);
			if(b==true) {
				System.out.println(bosluksorular.get(j)+"\tbunu sileyim mi?cevabýn evetse 1 e bas yoksa baska bir tuþa basabilirsin");
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
	protected void dogrucevap() {
		System.out.println("kaçýncý sorunun cevabýný istiyorsun?");
			Scanner klavye4=new Scanner(System.in);
		int girilen4=klavye4.nextInt();
			System.out.println(boslukcevaplar.get(girilen4-1));
			
		
		
	}

	@Override
	public int compareTo(Klasiksoru o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Klasiksoru o) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	
	}


