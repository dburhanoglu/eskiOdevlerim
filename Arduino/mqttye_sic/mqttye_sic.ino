// MQTT uygulaması. Shiftr.io sitesine bağlanıp, "sensorler/sicaklik" konusuna sicaklik degerini publish yapan program
// shiftr.io sitesinde hesap oluşturup, Deploy Instance diyerek proje oluşturunuz, oradaki bilgileri...
// kodda gerekli yerlere yazmanız gerekli 41. ve 64. satırlar
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <MQTTClient.h>

int sensor_deger=0;           // sensorden okunan degeri tutmak icin
float sicaklik_gerilim=0.0;   // sensorden okunan degerin gerilim karsiligi mV cinsinden
float sicaklik=0.0;           // sicaklik degeri

const char *ssid = "Deryab";                 // bağlanılacak olan kablosuz ağın SSID si
const char *password = "12345678";           // bağlanılacak olan kablosuz ağın şifresi

WiFiClient wifi_istemci;                      // wifi istemci nesnesi oluşturuldu
MQTTClient mqtt_istemci;                      // MQTT istemci nesnesi oluşturuldu
//------------------------------------------------------------------------------------
void setup(void) 
{
  Serial.begin(9600);                         //Seri iletişim hızı 9600 bps olarak ayarlanarak başlatılıyor.
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

  mqtt_istemci.begin("dogfinger723.cloud.shiftr.io", wifi_istemci);      // mqtt istemci nesnesini başlat. ilk parametre web adresi
                                                                   // ikinci parametre bağlantı kurulurken kullanılacak wifi nesnesi
}
//------------------------------------------------------------------------------------
void loop(void) 
{
  mqtt_istemci.loop();              // Mesaj göndermek ve almak için bu loop fonksiyonunu her döngü içerisinde çalıştırmak lazım
  delay(100);                       // 100 ms bekleme
  
  if(!mqtt_istemci.connected())     // bağlantı kurulmamış mı?
    baglan();                       // kurulmadıysa baglan fonksiyonuna git

  delay(1000);                      // 1 sn bekleme
  
  sicaklik_olc();                 // sicakliği ölç fonksiyona gidip

  // sensorler/sicaklik konusuna sicaklik değerini stringe dönüştürüp yayınla
  mqtt_istemci.publish("sensorler/sicaklik", String(sicaklik, 2)); 
}
//------------- shiftr.io sitesindeki örneğe bağlanma fonksiyonu ------------------
void baglan()
{
  // mqtt_istemci.connect("xxx", "yyy", "zzz") burada xxx bağlandığınızda görünen adınız, yyy projenin adı, zzz oluşturduğunuz token 
  while (!mqtt_istemci.connect("424", "dogfinger723", "sTXgddjngrF6EIIz"))  // projeye bağlanamadı mı?
  {                                                                    // evet bağlanamadı 1sn bekle tekrar kontrol et
    Serial.print(".");
    delay(1000);
  }
                                                                       // projeye bağlandı fonksiyondan geri dön
}
//--------------------------------------------------------------
void sicaklik_olc()
{
  sensor_deger=analogRead(A0);      // A0 analog girişini oku, ve okunan degeri sensor_deger'e ata
  sicaklik_gerilim = (sensor_deger / 1023.0)*1000;  //bu kismin açıklaması en alttadır
  sicaklik = sicaklik_gerilim /10.0;
}
