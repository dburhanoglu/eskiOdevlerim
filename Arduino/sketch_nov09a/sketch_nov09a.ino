#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <MQTTClient.h>

const char *ssid = "abc";                 // bağlanılacak olan kablosuz ağın SSID si
const char *password = "1234567899";           // bağlanılacak olan kablosuz ağın şifresi
int sensor_deger=0;           // sensorden okunan degeri tutmak icin
float sicaklik_gerilim=0.0;   // sensorden okunan degerin gerilim karsiligi mV cinsinden
float sicaklik=0;               // sicaklik degeri
WiFiClient istemci;                       // istemci nesnesi oluşturuldu
MQTTClient mqtt_istemci;

void setup(void) 
{
  Serial.begin(9600);                       //Seri iletişim hızı 9600 bps olarak ayarlanarak başlatılıyor.
  delay(1000);
  
  WiFi.mode(WIFI_STA);                        //ESP8266 istasyon moduna alınıyor. 
  WiFi.begin(ssid, password);                 //SSID ve şifre girilierek wifi başlatılıyor.

  Serial.print("Bağlantı kuruluyor");
  
  while (WiFi.status() != WL_CONNECTED) 
  { // Wifi bağlantısı sağlanana kadar bekleniyor.
    delay(500);                               // Bu arada her 500 ms de bir seri ekrana yan yana noktalar yazdırılarak
    Serial.print(".");                        //görsellik sağlanıyor.
  }
  
  Serial.println("");                         //Bir alt satıra geçiliyor.
  Serial.println("Bağlantı sağlandı...");      //seri ekrana bağlantının kurulduğu bilgisi gönderiliyor.

  Serial.print("Alınan IP addresi: ");        // kablosuz ağdan alınan IP adresi
  Serial.println(WiFi.localIP());             // kablosuz ağdan alınan IP adresi

  mqtt_istemci.begin("iot-no.cloud.shiftr.io/", istemci);
}
void loop(void) 
{
  mqtt_istemci.loop();
  delay(100);

  if(!mqtt_istemci.connected())
    baglan();
    
  delay(1000);
  sicaklik_olc();
  
  mqtt_istemci.publish("sicaklik", String(sicaklik,2));
}

void baglan()
{
  Serial.print("\nconnecting...");
  while(!mqtt_istemci.connect("derya", "iot-no", "2Wyn29v8qIU0rdkk")) {  //2Wyn29v8qIU0rdkk
    Serial.print(".");
    delay(1000);
  }
  Serial.print("baglandı");
}
void sicaklik_olc()
  {
     sensor_deger=analogRead(A0);      // A0 analog girişini oku, ve okunan degeri sensor_deger'e ata
  sicaklik_gerilim = (sensor_deger / 1023.0)*1000;  //bu kismin açıklaması en alttadır
  sicaklik = sicaklik_gerilim /10.0;
    
  }
