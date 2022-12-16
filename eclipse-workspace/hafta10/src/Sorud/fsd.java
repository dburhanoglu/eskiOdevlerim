

package Sorud;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Sinav_Uygulamasi{
	static ArrayList<Soru_Uygulamasi> soruBankasi = new ArrayList<Soru_Uygulamasi>();
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        
        
        ///////////////////////////////////////// KullanÄ±cÄ± arayÃ¼zÃ¼////////////////////////////////
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("1. Soru Ekle\n2. Soru Cikar\n3. Listele\n4. SýnavYap\n5. Cikis\nSec: ");
            int secim=scan.nextInt();
            switch(secim){
                case 1:{
                    Soru_Uygulamasi soru=null;
                    System.out.print("1. Test\n2.Dogru-Yanlis\n3.Bosluk Doldurma\n4.Klasik\n5. Cikis\nSec: ");
                    int secim1 = scan.nextInt();
                    switch(secim1){
                        case 1:{
                            
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("A= ");
                            String sýkA= scan.next();

                            System.out.print("B = ");
                            String sýkB = scan.next();

                            System.out.print("C = ");
                            String sýkC = scan.next();

                            System.out.print("D = ");
                            String sýkD = scan.next();
                            
                            System.out.print("Cevap(A,B,C,D) = ");
                            String cevap = scan.next();

                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int zorluk= scan.nextInt();
                            
                            soru= new TestSorusu_Tipi(sýkA , sýkB,  sýkC,  sýkD, cevap, puan, zorluk);
                            soruBankasi.add(soru);
                            break;
                        }
                        case 2:{
                            
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("Cevap(D,Y) = ");
                            String cevap = scan.next();
                            
                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int zorluk = scan.nextInt();
                            
                            soru = new DogruYanlisSorusu_Tipi(soruMetni, cevap, puan, zorluk);
                            soruBankasi.add(soru);
                            break;
                        }
                        case 3:{
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("Cevap = ");
                            String cevap = scan.next();
                            
                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int zorluk= scan.nextInt();
                            
                            soru = new DogruYanlisSorusu_Tipi();
                           soruBankasi.add(soru);
                            break;
                        }
                        case 4:{
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("Cevap = ");
                            String cevap = scan.next();
                            
                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int zorluk = scan.nextInt();
                            
                            soru = new DogruYanlisSorusu_Tipi();
                            soruBankasi.add(soru);
                            break;
                        }
                    }
                    SoruyuKaydet(soru);    ////////////////  Dosyaya kaydet
                    break;
                }
                case 2:{
                    System.out.print("Soru bul =");
                    String metin = scan.next();
                    if(Sil(metin)){
                        System.out.println("Silindi");
                    }
                    else{
                        System.out.println("Silinemedi");
                    }
                    break;
                }
                case 3:{
                    System.out.print("a.Soru Metni \nb.SÄ±klar Metni \nc.Cevaplar\nd.Puan\ne.Derece\nf.Soru Tipi\ng.Hepsi\nFiltre Sec:");
                    String secim2 = scan.next();
                    String filtre="";
                    if(secim2.equals("g")){
                        filtre = "";
                    }
                    else if(secim2.equals("f")){
                        System.out.print("1.Test\n2.Dogru/Yanlis\n3.Klasik\n4.Bosluk Doldurma\nSec:");
                        int secim3 = scan.nextInt();
                        if(secim3==1) filtre = "test";
                        if(secim3==2) filtre = "dy";
                        if(secim3==3) filtre = "klasik";
                        if(secim3==4) filtre = "bosluk";
                    }
                    else{
                        System.out.println("Aranan = ");
                        filtre = scan.next();
                    }
                    
                    scanner(Filtrele1(secim2, filtre));
                    break;
                }
                case 4:{
                    System.out.print("1.Test\n2.Klasik\n3.Karisik\nSec:");
                    int secim3 = scan.nextInt();
                    ArrayList<Soru_Uygulamasi> sinavSorulari = SinavSirala(SinavOlustur1(secim3));
                    ArrayList<Soru_Uygulamasi> yapilanlar = new ArrayList<>();
                    int puan=0;
                    for(int i=0;i<sinavSorulari.size();i++){
                        Soru_Uygulamasi soru=sinavSorulari.get(i);
                        System.out.println(i+".) "+ soru.getsoruMetni());
                        if(soru.equals(soru.getTipi())){
                            TestSorusu_Tipi test = (TestSorusu_Tipi) soru;
                            System.out.println("A.)"+test.getSýkA());
                            System.out.println("B.)"+test.getSýkB());
                            System.out.println("C.)"+test.getSýkC());
                            System.out.println("D.)"+test.getSýkD());
                        }
                        
                        System.out.print("Cevap =");
                        String cevap= scan.next();
                        soru.setVerilenCevap(cevap);
                        yapilanlar.add(soru);
                       // if( soru.getTipi().equals("test") && cevap.equals(soru.getDogruCevap())) puan+=soru.getPuan()
                        if( soru.equals(soru.getTipi()) && cevap.equals(soru.getDogruCevap())) puan+=soru.getPuan();
                    }
                    System.out.println("Test Sinavi Toplam Puan = " + puan);
                    SinaviKaydet(yapilanlar);
                    break;
                }
                case 5:{
                    System.exit(0);
                    break;
                }
            }
            
           
            
        }while(true);
    }
    
    
    
    private static void scanner(Object filtrele1) {
		// TODO Auto-generated method stub
		
	}



	private static void SinaviKaydet(ArrayList<Soru_Uygulamasi> yapilanlar) {
		// TODO Auto-generated method stub
		
	}



	private static ArrayList<Soru_Uygulamasi> SinavSirala(Object sinavOlustur) {
		// TODO Auto-generated method stub
		return null;
	}



	private static Object Filtrele1(String secim2, String filtre) {
		// TODO Auto-generated method stub
		return null;
	}



	private static Object SinavOlustur1(int secim3) {
		// TODO Auto-generated method stub
		return null;
	}



	private static void SoruyuKaydet(Soru_Uygulamasi soru) {
		// TODO Auto-generated method stub
		
	}



	private static ArrayList<Soru_Uygulamasi> SinavOlustur(int secim3) {
		// TODO Auto-generated method stub
		return null;
	}



	static void SoruyuKaydet1(Soru_Uygulamasi soru) throws FileNotFoundException, IOException{
        File f = new File("sorubankasi.dat");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(soru);
        oos.close();
        fos.close();
    }
    
    static void SinaviKaydet1(ArrayList<Soru_Uygulamasi> list) throws IOException{
        File f = new File("sinavlar.dat");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
    }
    
    static ArrayList<Soru_Uygulamasi> SinavOlustur(int secim, ArrayList<Soru_Uygulamasi> sýnavSorulari) throws FileNotFoundException{
        
        ArrayList<Soru_Uygulamasi> havuz = new ArrayList<>();
        if(secim == 1){
            havuz = (ArrayList<Soru_Uygulamasi>) Filtrele1("f","test");
        }
        if(secim == 2){
            havuz = (ArrayList<Soru_Uygulamasi>) Filtrele1("f","klasik");
        }
        if(secim == 3){
            havuz = soruBankasi;
        }
        
        ArrayList<Soru_Uygulamasi> sinavSorulari = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList();
        int TopPuan = 0;
        Random r=new Random();
        do{
            if(list.size() == havuz.size()) break;
            int i = r.nextInt(havuz.size());
            if(Kontrol(list, i)){
                Soru_Uygulamasi soru = havuz.get(i);
                sinavSorulari.add(soru);
                TopPuan += soru.getPuan();
                list.add(i);
            }
            if(TopPuan>=100 && TopPuan<=110) break;
        }while(true);
        return sýnavSorulari;
    }
    
    
    static boolean Kontrol(ArrayList<Integer> list,int i){
        for(int j=0;j<list.size();j++){
            if(list.get(j) == i) return false;
        }
        return true;
    }
    static ArrayList<Soru_Uygulamasi> Filtrele(String secim, String filtre ){
        ArrayList<Soru_Uygulamasi> sorular = new ArrayList<>();
        for(Soru_Uygulamasi soru : soruBankasi){
            switch(secim){
                case "a":{
                    if(soru.getsoruMetni().contains(filtre)) sorular.add(soru);
                    break;
                }
                case "b":{
                	     if(soru.equals(soru.getTipi())) 
                        //f(soru.getTipi().equals("test")){
                	    if (soru.equals("test")){
                        TestSorusu_Tipi ts = (TestSorusu_Tipi) soru;
                        if(( ts.getSýkA().contains(filtre) 
                            || ts.getSýkB().contains(filtre)
                            || ts.getSýkC().contains(filtre)
                            || ts.getSýkD().contains(filtre)
                        )) sorular.add(soru);
                	    }
                    }
                    break;
                        
                	     
                case "c":{
                    if(soru.getDogruCevap().equals(filtre)) sorular.add(soru);
                    break;
                }
                case "d": {
                    if(soru.getPuan() == Integer.parseInt(filtre)) sorular.add(soru);
                    break;
                }
                case "e":{
                    if(soru.getZorluk()== Integer.parseInt(filtre)) sorular.add(soru);
                    break;
                }
                case "f":{
                	if(soru.equals(filtre))sorular.add(soru);
					//if(soru.getTipi().equals(filtre)) sorular.add(soru);
                    break;
                }
                case "g":{
                    sorular.add(soru);
                }
            }
        }
        return Sirala(sorular);
    }
    
    static ArrayList<Soru_Uygulamasi> Sirala(ArrayList<Soru_Uygulamasi> list){
        for(int i=0;i<list.size();i++){
            for(int j=0; j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))<0){
                    Soru_Uygulamasi gecici = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, gecici);
                }
            }
        }
        return list;
    }
    
    static ArrayList<Soru_Uygulamasi> SinavSirala(ArrayList<Soru_Uygulamasi> sorular){
        ArrayList<Soru_Uygulamasi> list = new ArrayList<>();
        for(int i=0;i<sorular.size();i++){
           //if(sorular.get(i).getTipi().equals("test")) list.add(sorular.get(i));
        	if(sorular.ArrayList<>.getTipi().get(i).equals("test"))
        		list.add(sorular.get(i));
        }
        for(int i=0;i<sorular.size();i++){
           // if(sorular.get(i).getTipi().equals("klasik")) list.add(sorular.get(i));
        	 if(sorular.getTipi().get(i).equals("klasik"))
        		 list.add(sorular.get(i));
        }
       
        for(int i=0;i<sorular.size();i++){
            if(sorular.get(i).getTipi().equals("dy"))
            	list.add(sorular.get(i));
        }
        for(int i=0;i<soruBankasi.size();i++){
            if(soruBankasi.get(i).getTipi().equals("bosluk"))
            	list.add(soruBankasi.get(i));
        }
        return list;
    }
    
    static void Yazdir(Soru_Uygulamasi sorular){
        for(int i=0; i<sorular.size();i++){
            
			Soru_Uygulamasi sorular = (sorular.get(i));
            System.out.println(i + ".)" + sorular.getsoruMetni());
            //if(soru.getTip().equals("test"))
            if(sorular.equals("test"))
            {
                TestSorusu_Tipi ts = (TestSorusu_Tipi) sorular;
                System.out.println("A.)"+ ts.getSýkA());
                System.out.println("B.)"+ ts.getSýkB());
                System.out.println("C.)"+ ts.getSýkC());
                System.out.println("D.)"+ ts.getSýkD());
            }
            System.out.println("Dogru Cevap=)"+ sorular.getDogruCevap());
            System.out.println("Puan=)"+ sorular.getPuan());
            System.out.println("Derece=)"+ sorular.getZorluk());
            System.out.println("Tipi=)"+ sorular.getTipi());
        }
    }
    
    static boolean Sil(String metin){
        for(int i=0;i<soruBankasi.size();i++){
            if(soruBankasi.get(i).getsoruMetni().contains(metin)){
                soruBankasi.remove(i);
                return true;
            }
        }
        return false;
    } 
}