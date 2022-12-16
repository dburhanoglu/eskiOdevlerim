// firebase realtime database e oda sıcaklığını ölçüp yaz, sonra yazdığını tekrar oku 
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <FirebaseArduino.h>

const char *ssid = "Deryab";                 // bağlanılacak olan kablosuz ağın SSID si
const char *password = "12345678";           // bağlanılacak olan kablosuz ağın şifresi

#define firebase_erisim_linki "derya1-default-rtdb.firebaseio.com"   // oluşturduğunuz projenizdeki veritabanınızın erişim linki
#define firebase_sifre "mnqygcYnpYSJ8QTse36rzgTyIhtmUDnb3o0ZdRn1"    // veritabanı secret key

int sensor_deger=0;           // sensorden okunan degeri tutmak icin
float sicaklik_gerilim=0.0;   // sensorden okunan degerin gerilim karsiligi mV cinsinden
float sicaklik=0.0;           // sicaklik degeri
//------------------------------------------------------------------------------------
void setup(void) 
{
 pinMode(D1,OUTPUT);
 digitalWrite(D1,LOW);
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
  
  Firebase.begin(firebase_erisim_linki, firebase_sifre);      // Firebase erişimini başlat
}
//------------------------------------------------------------------------------------
void loop(void) 
{
  sicak_olc();    // sıcaklığı ölç

  Firebase.setFloat("Oda Sicakligi",sicaklik);          // "Oda Sicakligi" etiketinin altına sıcaklıgı yaz
  if (Firebase.failed()) {                              // yazma hatası oldu mu?
      Serial.print("Hata Var:");                        // evet olmuş, seri porttan bana bildir
      Serial.println(Firebase.error());  
      return;                                           // loop başına dön
  }
  delay(1000);
  float ayarlanan_deger=Firebase.getFloat("ayarlanan deger");
  if(ayarlanan_deger<sicaklik)
  digitalWrite(D1,LOW);
  else
  digitalWrite(D1,HIGH);
  

}
//-------------------- sıcaklık ölçme fonksiyonu ------------------------
void sicak_olc()
{
  sensor_deger=analogRead(A0);      // A0 analog girişini oku, ve okunan degeri sensor_deger'e ata
  sicaklik_gerilim = (sensor_deger / 1023.0)*1000;  //bu kismin açıklaması en alttadır
  sicaklik = sicaklik_gerilim /10.0;
}
