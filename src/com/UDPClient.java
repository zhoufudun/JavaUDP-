package com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/***
 * UDPclientClient��
 ***/
public class UDPClient {
   
    private String sendStr = "SendString";
    private String netAddress = "127.0.0.1";
    private final int PORT_NUM = 5066;
   
    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;
   
    public UDPClient(){
        try {
           
            /*** ��������***/
            // ��ʼ��datagramSocket,ע����ǰ��Server��ʵ�ֵĲ��
            datagramSocket = new DatagramSocket();
            // ʹ��DatagramPacket(byte buf[], int length, InetAddress address, int port)������װ����UDP���ݱ�
            byte[] buf = sendStr.getBytes();
            InetAddress address = InetAddress.getByName(netAddress);
            datagramPacket = new DatagramPacket(buf, buf.length, address, PORT_NUM);
            // ��������
            datagramSocket.send(datagramPacket);
           
            /*** ��������***/
            byte[] receBuf = new byte[1024];
            DatagramPacket recePacket = new DatagramPacket(receBuf, receBuf.length);
            datagramSocket.receive(recePacket);
           
            String receStr = new String(recePacket.getData(), 0 , recePacket.getLength());
            System.out.println("Client Rece Ack:" + receStr);
            System.out.println(recePacket.getPort());
           
           
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }  
    public static void main(String[] args) {
    	UDPClient client =new UDPClient();
	}
}
