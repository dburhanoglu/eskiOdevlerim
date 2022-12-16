package artýkbasla;

import java.util.Scanner;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
//import artýkbasla.Soru.zorluk;

public class SoruBankasý  {
	public static void main(String []args) {	
		
		
		Vector<testtipi>icerik=new Vector<>();
		icerik.add(new testtipi("ghj","hjkl","ghj",1,6));
		icerik.add(new testtipi("ghj","hjkl","ghj",1,4));
		icerik.add(new testtipi("ghj","hjkl","ghj",2,55));
		/*Iterator itr = icerik.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		Collections.sort(icerik);
		for(testtipi deger:icerik) {
			System.out.println(icerik);
		}
		
		}

	
	

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

/*System.out.println("eklemek istediginiz soru tipi klasik iste 1 e çoktansecmeli ise 2 ye doðru yanlýþ ise 3 e boslukdoldurma ise 4 e basýnýz");
	Scanner klavye=new Scanner(System.in);
	int girilen=klavye.nextInt();
	if(girilen==1)
	{
		Soru c1=new Klasiksoru();
		c1.Soruekle();
		//c1.Sorusil();
	//c1.zorluklistele();
				c1.Metinicerenlistele();

		}
		
	else if(girilen==2) 
	{
		Soru c2=new Testsoru();
	     c2.Soruekle();
	     
	}
	else if(girilen==3)
	{
		Soru c3=new Dysoru();
		c3.Soruekle();
		
	}
	else {
		Soru c4=new Bosluksoru();
		c4.Soruekle();
		c4.Sorusil();
		//c4.dogrucevap();
		
	}	
	
}    
	
	}*/