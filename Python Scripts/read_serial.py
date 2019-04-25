import serial
import server
import thread
import filehandling


filePath = "/tmp/mood.csv";
filehandling.createCsv(filePath)
thread.start_new_thread(server.server_program,())

serial_port = '/dev/ttyACM0';
baud_rate = 9600; #In arduino, Serial.begin(baud_rate)
ser = serial.Serial(serial_port, baud_rate)
fi = open(filePath,"a")

while True:
    line = ser.readline();
    line = line.decode("utf-8") #ser.readline returns a binary, convert to string
    string = line.replace("\n","")
    l = line.split()
    string = string.join(l)
    string = string+","+server.MOOD+"\n"
    if string.count(",")==2:
        fi.write(string)
        print(string)
