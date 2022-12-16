package degisim;



import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Klasiksoru extends Soru 
{
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
            System.out.println("þimdi de bu sorunun puanýný giriniz");
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
	public int compareTo(Klasiksoru o) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	}
	
	

	
	
	
		


	
	