// ESP modlununu istasyon, station olarak ayarla, MQTT sitesine bağlan
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <MQTTClient.h>

const char *ssid = "abc";      // baglanilacak olan wifi aginin adi  
const char *password = "1234567899";      // baglanilacak olan wifi aginin sifresi

unsigned long lastMillis = 0;

MQTTClient mqtt_istemci;                // mqtt_istemci nesnesini olustur
WiFiClient wifi_istemci;                // wifi_istemci nesnesini olustur
//************************************************************
void setup() {
  Serial.begin(9600);                   // seri portu baslat
  delay(1000);                          // 1000 ms = 1sn
 
  WiFi.mode(WIFI_STA);                  // istasyon modunda çalış
  WiFi.begin(ssid, password);           // SSID si yukarıda belirtilmiş olan wifi a bağlan
  
  while (WiFi.status() != WL_CONNECTED) // baglanti kuruldu mu?
  {                                     // kurulmadiysa kurulana kaddar 
    delay(500);                         // 500 ms bekle
    Serial.print(".");                  // ekrana . koy    
  }
  
  Serial.println("");
  Serial.println("Wifi erisim noktasina baglanildi");

  Serial.print("Alinan IP adresi: ");
  Serial.println(WiFi.localIP());       // wifi agindan alinan IP adresini yazdir.

  Serial.println("MQTT Broker'a baglaniyor...");
  mqtt_istemci.begin("seyf-iot.cloud.shiftr.io", wifi_istemci); // mqtt sitesine baglanma
}
//************************************************************
void loop() 
{
  mqtt_istemci.loop();                  
  if(!mqtt_istemci.connected()) {
    baglan();
  }
  
  if(millis() - lastMillis > 1000)                        // saniyede bir gonderme icin
  {
    lastMillis = millis();
    mqtt_istemci.publish("/sicaklik", "26");     // sensorler/sicaklik konusuna 26 gonder
      //sensorler/nem konusuna 20 gonder
  }
}
//************************************************************
void baglan()       
{
  Serial.println("Baglaniyor...");

  // mqtt_istemci.connect("publisher veya subscriber adi","username","password");
  while (!mqtt_istemci.connect("derya_iot", "iot-no", "2Wyn29v8qIU0rdkk"))
  {
       Serial.print(".");
  }
  Serial.println("Projeye baglandi");
}
