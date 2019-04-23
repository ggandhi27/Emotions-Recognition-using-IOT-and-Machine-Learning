import thread
import socket


def receive_program(conn,address) :
    while True:
        data = conn.recv(1024).decode()
        if not data:
            # if data is not received break
            break
        print("from connected user: " + str(data))


def send_program(conn,address) :
    while True:
        data = raw_input(' -> ')
        conn.send(data.encode())  # send data to the client


def server_program():
    # get the hostname
    host = socket.gethostname()
    port = 5000  # initiate port no above 1024

    server_socket = socket.socket()  # get instance
    # look closely. The bind() function takes tuple as argument
    server_socket.bind((host, port))  # bind host address and port together

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


if __name__ == '__main__':
    server_program()

