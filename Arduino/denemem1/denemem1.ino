 #include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
int sensor_deger=0;           // sensorden okunan degeri tutmak icin
float sicaklik_gerilim=0.0;   // sensorden okunan degerin gerilim karsiligi mV cinsinden
int sicaklik=0;               // sicaklik degeri
const char *ssid = "emineccccc";                // *** yazan yere kablosuz ağınız için ID yazın
const char *password = "12345678";            // *** yazan yere kablosuz ağınız için şifre (min 8 karakter) yazın

ESP8266WebServer sunucu(80);                // sunucu nesnesi oluşturuluyor, 80 nolu http portu kullanılıyor
//------------------------------------------------------------------------------------
void setup() {
  Serial.begin(9600);                       // Seri portu başlat, veri gönderim hızı (baud rate) 9600bps
  delay(1000);                              // Seri portun açılması için 1sn bekle
  Serial.println("Kod basliyor...");        // Seri porttan "" içindeki yazıyı gönder 
  
  WiFi.mode(WIFI_AP);                        // NodeMCU (AP-Access Point)erişim noktası moduna alınıyor. Modlar: WIFI_AP, WIFI_STA, WIFI_AP_STA
  WiFi.softAP(ssid, password);               // SSID ve şifre girilerek wifi başlatılıyor.

  
  IPAddress erisim_IP = WiFi.softAPIP();     // erişim noktasının IP adresi erisim_IP'ye aktarılıyor
  Serial.print("AP IP address: ");
  Serial.println(erisim_IP);                 // IP adresini seri portta yazıdr.
  
  
  sunucu.on("/", anasayfa);                  // Eğer browsera IP adresi yazılırsa ana sayfa alt programı çalışacak.
  //sunucu.on("/iletisim",iletisim_fonk);      // Eğer browsera IP adresi /iletisim (örn: xxx.xxx.xxx.xxx/iletisim) yazılırsa iletisim_fonk alt programı çalışacak.
  sunucu.onNotFound(bilinmeyen_sayfa);       // Eğer browsera bilinmeyen bir adres yazılırsa bilinmeyen_sayfa alt programı çalışacak.
  
  sunucu.begin();                            // HTTP web sunucusunu başlat
  
  Serial.println("HTTP sunucusu baslatildi");// Seri porttan "" içindeki yazıyı gönder 
}
//------------------------------------------------------------------------------------


//---------------------------------------------------
void loop() {
  // put your main code here, to run repeatedly:
 sunucu.handleClient();                     // istemci bağlantılarını idare et

}
void anasayfa()                                   // Web serverımızın ip adresi her çağrıldığında ekranda 
{    
  sicaklik_olc();// görüntülecek html sayfası alt program aracılığıyla gösteriliyor.              
  String sayfa="<!doctype html>";                 // html sayfası oluşturularak "sayfa" ismindeki string değişkene kaydediliyor.
         sayfa+="<html>";                         
         sayfa+="<head>";                      
         sayfa+="<title>Nesnelerin Interneti</title>";
         sayfa+="</head>";
         sayfa+="<body>";
         sayfa+="<h2>Hoşgeldiniz</h2>";
         sayfa+="<h2>sicaklik:"+String(sicaklik,2)+"<h2>";
         sayfa+="</body>";
         sayfa+="</html>";  

 sunucu.send(200, "text/html; charset=utf-8", sayfa);          //Oluşturulan web sayfası tarayıcıya gönderiliyor.
  
}
void bilinmeyen_sayfa(){
  sunucu.send(404, "text/plain; charset=utf-8", "404: Sayfa Bulunamadı."); 
}
void sicaklik_olc()
{
   sensor_deger=analogRead(A0);      // A0 analog girişini oku, ve okunan degeri sensor_deger'e ata
  sicaklik_gerilim = (sensor_deger / 1023.0)*1000;  //bu kismin açıklaması en alttadır
  sicaklik = sicaklik_gerilim /10.0;
}
