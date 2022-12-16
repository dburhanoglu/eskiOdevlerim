#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include "ThingSpeak.h" 

const char *ssid = "deryab";                 // bağlanılacak olan kablosuz ağın SSID si
const char *password = "12345678";           // bağlanılacak olan kablosuz ağın şifresi

unsigned long channel_no = 1607124;
const char * myWriteAPIKey = "MI13DXD0S9E715SP";

WiFiClient wifi_istemci;                     // wifi istemci nesnesi oluşturuldu
//------------------------------------------------------------------------------------
void setup(void) 
{
  pinMode(D4, OUTPUT);                       // D1 portunu çıkış olarak ayarla
  digitalWrite(D4,LOW);                      // D1 LEDini başlangıç için söndür
  
  Serial.begin(9600);                        //Seri iletişim hızı 9600 bps olarak ayarlanarak başlatılıyor.
  delay(1000);
  
  WiFi.mode(WIFI_STA);                       //ESP8266 istasyon moduna alınıyor. 
  WiFi.begin(ssid, password);                //SSID ve şifre girilierek wifi başlatılıyor.

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
  ThingSpeak.begin(wifi_istemci);  // Initialize ThingSpeak
}
//------------------------------------------------------------------------------------
void loop(void) 
{int x = ThingSpeak.writeField(channel_no, 1, 23, myWriteAPIKey);
  if(x == 200){
    Serial.println("Channel update successful.");
  }
  else{
    Serial.println("Problem updating channel. HTTP error code " + String(x));
  }
 delay(17000);
}
//-------------------------------------------------------------
