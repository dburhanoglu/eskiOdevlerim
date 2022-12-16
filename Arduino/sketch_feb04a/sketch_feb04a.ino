int potpin=A0;
int potdeger;
void setup() {
  // put your setup code here, to run once:
pinMode(potpin,INPUT);
Serial.begin(9600);



}

void loop() {
potdeger=analogRead(potpin);
Serial.println(potdeger);


}
