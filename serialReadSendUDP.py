#File Called serialReadSendUDP.py

import serial
import socket

#define the server address
UDP_IP = "192.168.0.8"
UDP_PORT = 9876

#define the serial to be read and open it
arduinoSerialData = serial.Serial('/dev/ttyACM0', 9600)
arduinoSerialData.open()

#create the connection to the UDP server
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

#loops to find data received
while (True):
    if(arduinoSerialData.inWaiting() > 0):
        response = arduinoSerialData.readline()
        #send the message to UDP Server
        sock.sendto(response.encode('utf-8'), (UDP_IP, UDP_PORT))
        print response
    
    
