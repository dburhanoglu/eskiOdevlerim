// firebase realtime database e oda sıcaklığını ölçüp yaz, databaseden ayarlanan sıcaklığı oku
// ayarlanan sıcaklık ile oda sıcaklığını karşılaştırp ona göre röleyi çektir veya bıraktır 
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <FirebaseArduino.h>

const char *ssid = "Deryab";                 // bağlanılacak olan kablosuz ağın SSID si
const char *password = "12345678";           // bağlanılacak olan kablosuz ağın şifresi

#define firebase_erisim_linki "derya1-default-rtdb.firebaseio.com"   // oluşturduğunuz projenizdeki veritabanınızın erişim linki
#define firebase_sifre "mnqygcYnpYSJ8QTse36rzgTyIhtmUDnb3o0ZdRn1"           // veritabanı secret key

int sensor_deger=0;           // sensorden okunan degeri tutmak icin
float sicaklik_gerilim=0.0;   // sensorden okunan degerin gerilim karsiligi mV cinsinden
float sicaklik=0.0;           // sicaklik degeri
//------------------------------------------------------------------------------------
void setup(void) 
{
  pinMode(D6,OUTPUT);                       // D6 pinini çıkış yap röle bağlı
  digitalWrite(D6,LOW);                     // röleyi bıraktır
  
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
  

  int ayarlanan_deger=Firebase.getInt("Ayarlanan");     // "Ayarlanan" etiketi altındaki veriyi oku, ayarlanan_degere ata

  if(ayarlanan_deger>sicaklik)                          // Oda sıcaklığı ayarlanan degerden küçük mü?
    digitalWrite(D6,HIGH);                              // küçük röleyi çektir
  else
    digitalWrite(D6,LOW);
  
}
//-------------------- sıcaklık ölçme fonksiyonu ------------------------
void sicak_olc()
{
  sensor_deger=analogRead(A0);      // A0 analog girişini oku, ve okunan degeri sensor_deger'e ata
  sicaklik_gerilim = (sensor_deger / 1023.0)*1000;  //bu kismin açıklaması en alttadır
  sicaklik = sicaklik_gerilim /10.0;
}
