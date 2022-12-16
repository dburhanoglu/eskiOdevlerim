package artýkbasla;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Klasiksoru extends Soru  {
	Vector<String> klasiksorular=new Vector();
Vector<Integer>klasikzorluklar=new Vector();
Vector<Integer>klasikpuanlar=new Vector();
		

	@Override
	public void Soruekle() {

		System.out.println("kaç soru girmek istersiniz");
		Scanner klavye1=new Scanner(System.in);
		int girilen1 =klavye1.nextInt();
		
		for(int i=0;i<girilen1;i++)
		{
			System.out.println("soru giriniz");
		   Scanner klavye2=new Scanner(System.in);
		   String girilen2=klavye2.nextLine();
		   klasiksorular.add(girilen2);
		 	System.out.println("þimdi de zorluðunu girin 1 kolay 2 orta 3 zor");
		 	Scanner klavye3=new Scanner(System.in);
	 		int girilen3=klavye3.nextInt();
	 		klasikzorluklar.add(girilen3);
            System.out.println("þimdi de bu sorunun puanýný giriniz 5 10 veya 20 giriniz");
            Scanner klavye4=new Scanner(System.in);
            int girilen4=klavye4.nextInt();
            klasikpuanlar.add(girilen4);
	    }
	    System.out.println("klasik soru girme iþlemi tamamlandý");
		System.out.println(klasiksorular);
	    System.out.println(klasikzorluklar);
	    System.out.println(klasikpuanlar);
	 		}
	@Override
	public void Sorusil() {
		int j;
		     System.out.println("silmek istediðiniz soruda geçen kelimeyi giriniz");
		     Scanner klavye5=new Scanner(System.in);
		     String girilen5=klavye5.nextLine();
		    for( j=0;j<klasiksorular.size();j++) {
			boolean b=klasiksorular.get(j).contains(girilen5);
			if(b==true) 
			{
			 System.out.println(klasiksorular.get(j)+"\tbunu sileyim mi?cevabýn evetse 1 e bas yoksa baska bir tuþa basabilirsin");
			 Scanner klavye6=new Scanner(System.in);
			  int c=klavye6.nextInt();
			   if(c==1)
				klasiksorular.set(j,null);
			   else
				continue;
			}				
		}
		
		System.out.println(klasiksorular);
		
	}
	/*@Override
	protected void dogrucevap() {
		// TODO Auto-generated method stub
		
	}*/
	@Override
	protected void zorluklistele() {
		System.out.println("zordan kolaya listeleyelim");
		for(int i=0;i<klasikzorluklar.size();i++){
			if(klasikzorluklar.get(i)==3) {
				System.out.println("iþte zor sorular");
				System.out.println(klasiksorular.get(i));
			}}
			for(int j=0;j<klasikzorluklar.size();j++){
				if(klasikzorluklar.get(j)==2) {
					System.out.println("iþte orta sorular");
					System.out.println(klasiksorular.get(j));
				}}
				for(int k=0;k<klasikzorluklar.size();k++){
					if(klasikzorluklar.get(k)==1) {
						System.out.println("iþte kolay sorular");
						System.out.println(klasiksorular.get(k));
					}}
		}

	@Override
	protected void puanlistele() {
		System.out.println("yüksek puandan alcaga doðru  listeleyelim");
		for(int i=0;i<klasikpuanlar.size();i++){
			if(klasikpuanlar.get(i)==20) {
				System.out.println("iþte 20 puanlýk sorular");
				System.out.println(klasiksorular.get(i));
			}}
		
		for(int j=0;j<klasikpuanlar.size();j++){
			if(klasikpuanlar.get(j)==10) {          ///NOTTTTTTTTTTT BURALARDA ÝF ELSE YAP 
				System.out.println("iþte 10 puanlýk sorular");
				System.out.println(klasiksorular.get(j));
			}}
	
		for(int k=0;k<klasikpuanlar.size();k++){
			if(klasikpuanlar.get(k)==5) {
				System.out.println("iþte 5 puanlýk sorular");
				System.out.println(klasiksorular.get(k));
			}}
		
	}
	@Override
	public void Metinicerenlistele() {
		System.out.println("hangi kelimenin geçtiði sorularý listeleyelim?lütfen kelimeyi giriniz");
		Scanner klavye=new Scanner(System.in);
		String kelime=klavye.nextLine();
		for(int i=0;i<klasiksorular.size();i++) {
			boolean b=klasiksorular.get(i).contains(kelime);
			if(b==true)
		System.out.println(klasiksorular.get(i));
		}
		
		
		
		
	}
		
	}
	
	
	

	
	
	
		


	
	
	
		
		

