package degisim;



import java.util.Scanner;



public class SoruBankas�  {
	public static void main(String []args) {	
System.out.println("eklemek istediginiz soru tipi klasik iste 1 e �oktansecmeli ise 2 ye do�ru yanl�� ise 3 e boslukdoldurma ise 4 e bas�n�z");
	Scanner klavye=new Scanner(System.in);
	int girilen=klavye.nextInt();
	if(girilen==1)
	{
		Soru c1=new Klasiksoru();
		c1.Soruekle();
		c1.Sorusil();
		int i=0;
		

		}
		
	else if(girilen==2) 
	{
		/*Soru c2=new Testsoru();
	     c2.Soruekle();*/
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
		c4.dogrucevap();
	}	
	
}    
	
	}