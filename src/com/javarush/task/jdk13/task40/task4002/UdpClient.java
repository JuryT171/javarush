package com.javarush.task.jdk13.task40.task4002;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UdpClient {

    private final DatagramSocket socket;
    private final InetAddress serverAddress;
    private final int serverPort;

    public UdpClient(int port) throws IOException {
        socket = new DatagramSocket(port);
        serverAddress = InetAddress.getByName("localhost");
        serverPort = 4445;
    }

    public String sendReceive(String message) throws IOException {
        //напишите тут ваш код

            byte []buff = message.getBytes(); //  преобразуем текст в байты
            // создаем UDP пакетдля отправки (текст,длина тексат, айпи,порт
            DatagramPacket packet = new DatagramPacket(buff, buff.length,serverAddress,serverPort);
            socket.send(packet); //  отправляем пакет
            // создаем пустой пакет для приема (массив размером 1024 байт)
            DatagramPacket newPacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(newPacket); // принимаем, при получении пакет заполняется

        return new String(packet.getData(),0,packet.getLength()); // новая строка, массив байтов, с нуля,
        // гетленгхт - колличество для преобразования(все)
    }

    public void close() {
        socket.close();
    }
}
