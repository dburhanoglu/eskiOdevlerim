// firebase realtime database e oda sıcaklığını ölçüp yaz, databaseden ayarlanan sıcaklığı oku
// ayarlanan sıcaklık ile oda sıcaklığını karşılaştırp ona göre röleyi çektir veya bıraktır 
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <FirebaseArduino.h>

const char *ssid = "Deryab";                 // bağlanılacak olan kablosuz ağın SSID si
const char *password = "12345678";           // bağlanılacak olan kablosuz ağın şifresi

#define firebase_erisim_linki "derya1-default-rtdb.firebaseio.com"   // oluşturduğunuz projenizdeki veritabanınızın erişim linki
#define firebase_sifre "mnqygcYnpYSJ8QTse36rzgTyIhtmUDnb3o0ZdRn1"           // veritabanı secret key


float sicaklik=70.0;           // sicaklik degeri
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
 // sıcaklığı ölç

  Firebase.setFloat("Oda Sicakligi",sicaklik);          // "Oda Sicakligi" etiketinin altına sıcaklıgı yaz
  if (Firebase.failed()) {                              // yazma hatası oldu mu?
      Serial.print("Hata Var:");                        // evet olmuş, seri porttan bana bildir
      Serial.println(Firebase.error());  
      return;                                           // loop başına dön
  }
  delay(1000);

  int ayarlanan_deger=Firebase.getInt("data");     // "Ayarlanan" etiketi altındaki veriyi oku, ayarlanan_degere ata
 
  Firebase.setFloat("Oda Sicakligi",ayarlanan_deger);
}
//-------------------- sıcaklık ölçme fonksiyonu ------------------------
