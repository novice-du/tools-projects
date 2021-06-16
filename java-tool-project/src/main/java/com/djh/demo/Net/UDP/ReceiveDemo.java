package com.djh.demo.Net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 使用UDP协议接受数据
 *  1.创建接受端Socket对象
 *  2.接受数据
 *  3.解析数据
 *  4.处理数据
 *  5.释放资源
 *
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接受数据的Socket对象
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        socket.receive(packet);//阻塞

        //解析数据
        InetAddress inetAddress = packet.getAddress(); //获取发送端的IP对象
        //packet.getData(); //获取发送端的数据
        //packet.getLength();  //获取具体数据的长度
        int length = packet.getLength();
        System.out.println("SendAddress: "+inetAddress.getHostAddress());
        System.out.println(new String(bytes,0,length));
        socket.close();
    }
}
