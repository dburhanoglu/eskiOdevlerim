int sensor_deger==;
float sicaklik_gerilim=0;
int sicaklik=0;





void setup() {
  // put your setup code here, to run once:
serial.begin(9600);//seri portu aç
digitalWrite(D2,LOW);


}

void loop() {
  // put your main code here, to run repeatedly:

sensor_deger=analogRead(A0);
sicaklik_gerilim(sensor_deger/1023.0)*1000;
sicaklik=sicaklik_gerilim/10.0;
Serial.print("sicaklik");
Serial.print(sicaklik);
delay(1000);

print(
}
