void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  int veri = analogRead(A0);
  Serial.println(veri);
  // put your main code here, to run repeatedly:

}
