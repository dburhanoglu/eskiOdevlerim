// Thingspeak sitesine bağlanıp, çoklu veri yazıp, Field 1'i okuyan program
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include "ThingSpeak.h"
#include <FirebaseArduino.h>

const char *ssid = "Deryab";          // bağlanılacak olan kablosuz ağın SSID si
const char *password = "12345678";           // bağlanılacak olan kablosuz ağın şifresi

unsigned long channel_ID =  1607124;           // thingspeak sitesindeki Channel numaranız
const char * myReadAPIKey = "2TUVCK5361ZKI2HP";  // thingspeak sitesindeki read api keyiniz
const char * myWriteAPIKey = "MI13DXD0S9E715SP";

#define firebase_erisim_linki "derya1-default-rtdb.firebaseio.com"   // oluşturduğunuz projenizdeki veritabanınızın erişim linki
#define firebase_sifre "mnqygcYnpYSJ8QTse36rzgTyIhtmUDnb3o0ZdRn1"           // veritabanı secret key


WiFiClient wifi_istemci;                       // istemci nesnesi oluşturuldu
//------------------------------------------------------------------------------------
void setup(void) 
{
  pinMode(D0,OUTPUT);     // D0 pinini çıkış yap
  digitalWrite(D0,LOW);   // D0 ı başlangıç için low yap

  Serial.begin(9600);                       //Seri iletişim hızı 9600 bps olarak ayarlanarak başlatılıyor.
  delay(1000);
  
  WiFi.mode(WIFI_STA);                        //ESP8266 istasyon moduna alınıyor. 
  WiFi.begin(ssid, password);                 //SSID ve şifre girilierek wifi başlatılıyor.

  //------- Wifi ağına bağlanıncaya kadar beklenilen kısım ------------
  Serial.print("Bağlantı kuruluyor");
  while (WiFi.status() != WL_CONNECTED) 
  { // Wifi bağlantısı sağlanana kadar bekleniyor.
    delay(500);                               // Bu arada her 500 ms de bir seri ekrana yan yana noktalar yazdırılarak
    Serial.print(".");                        //görsellik sağlanıyor.
  }
  //-------------------------------------------------------------------
  
  Serial.println("");                         //Bir alt satıra geçiliyor.
  Serial.println("Bağlantı sağlandı...");      //seri ekrana bağlantının kurulduğu bilgisi gönderiliyor.

  Serial.print("Alınan IP addresi: ");        // kablosuz ağdan alınan IP adresi
  Serial.println(WiFi.localIP());             // kablosuz ağdan alınan IP adresi
   Firebase.begin(firebase_erisim_linki, firebase_sifre);
  ThingSpeak.begin(wifi_istemci);    
  // Thingspeak bağlantısını başlat
     
}
//------------------------------------------------------------------------------------
void loop(void) 
{
 int okunacak=70;     // sicaklik değerini ölç

  int noson=1047;   // nem ve gaz sensörümüz olmadığı için bu değerler sabit olsun
  
  ThingSpeak.setField(1, okunacak);   // alan 1 e sicaklik degeri yazılacak
  ThingSpeak.setField(2, noson);    // alan 2 ye nem degeri yazılacak
   

  int x = ThingSpeak.writeFields(channel_ID, myWriteAPIKey); // Yukarıda set edilen alanlara çoklu veri yaz
  
  if(x == 200)
    Serial.println("Kanala veri yazildi");
  else
    Serial.println("Hata var. HTTP hata kodu: " + String(x));

  delay(17000);
  
  float okunan_deger=ThingSpeak.readFloatField(channel_ID, 1, myReadAPIKey); // alan 1 i oku
  delay(3000);
  ThingSpeak.setField(4,(okunan_deger*noson));
 Firebase.setFloat("Oda Sicakligi",(okunan_deger*noson)); 
   if (Firebase.failed()) {                              // yazma hatası oldu mu?
      Serial.print("Hata Var:");                        // evet olmuş, seri porttan bana bildir
      Serial.println(Firebase.error());  
      return;                                           // loop başına dön
  }
  delay(1000);
  
}
//---------------- sicaklik ölçme fonksiyonu -----------------------
