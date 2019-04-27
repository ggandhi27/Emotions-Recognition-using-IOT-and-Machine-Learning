const int TEMP=A2;
const int PULSE=A0;

int temp_val = 0;
int pulse_val = 0;
float temp = 0;

void setup() {
  // put your setup code here, to run once:

  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:

 temp_val = analogRead(TEMP);
 pulse_val = analogRead(PULSE);

 temp = (5.0*temp_val*100.0)/1024;

 Serial.print(temp);
 Serial.print(",");
 Serial.print(pulse_val);

 delay(1000);
}
