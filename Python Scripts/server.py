import thread
import socket
import random

MOOD = "Happy"
RESULT = "Happy"
flag = ""

def receive_program(conn,address) :
    global MOOD
    while True:
        data = conn.recv(1024).decode()
        if not data:
            # if data is not received break
            break

        data = data[2:]
        data = data.split()
        string = ""
        string = string.join(data)
        print("String :: "+string)
        if (MOOD != string):
            MOOD = string

def send_program(conn,address) :
    global RESULT
    global flag

    while True:
        if flag != RESULT :
            flag = RESULT
            result = RESULT+"\n"
            conn.send(result.encode())  # send data to the client


def server_program():
    # get the hostname
    host = socket.gethostname()
    host = socket.gethostbyname(host)
    server_socket = socket.socket()  # get instance
    # look closely. The bind() function takes tuple as argument
    
    port = 0
    while True:
        port = random.randint(1000,9999)  # initiate port no above 1024
        try:
            server_socket.bind((host, port))  # bind host address and port together
            break
        except OSError as e :
            continue
    print "IP Address :: "+host
    print "Port :: "+str(port)

    # configure how many client the server can listen simultaneously
    server_socket.listen(2)
    connection = server_socket.accept()  # accept new connection
    print("Connection from: " + str(connection[1]))
    thread.start_new_thread(receive_program,connection)
    thread.start_new_thread(send_program,connection)

    conn = connection[0]

    while True:
        None

    conn.close()  # close the connection

