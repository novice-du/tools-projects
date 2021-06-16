package com.djh.demo.Net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP：数据打包，不需要建立连接，不可靠，数据大小有限制(64k)，速度快
 * 使用UDP协议发送数据
 * 1.创建发送端Socket对象
 * 2.创建数据并打包
 * 3.发送数据
 * 4.释放资源
 *
 * DatagramSocket(): 创建Socket对象并随机分配端口号
 * DatagramSocket(int port): 创建Socket对象并指定端口
 * 作为发送端无需知道自己端口号，只需要对方端口号即可
 *
 * DatagramPacket(byte[] buf,int length,InetAddress address,int port)数组打包构造
 */
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String s = "nihao";
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        InetAddress inetAddress = InetAddress.getByName("192.168.0.107");
        int port = 8888;
        //将数据打包
        DatagramPacket dp = new DatagramPacket(bytes,length,inetAddress,port);
        socket.send(dp);
        socket.close();
    }
}
