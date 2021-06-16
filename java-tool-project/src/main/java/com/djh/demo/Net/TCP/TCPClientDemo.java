package com.djh.demo.Net.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *  TCP:需要三次握手、建立连接，可靠协议，效率稍低
 *  1.创建发送端Socket对象(创建连接)
 *  2.获取输出流对象
 *  3.发送数据
 *  4.释放资源
 *
 *  tcp需要建立连接，所以需要接收端也写完才能启动发送端，否则会报错
 *
 *  关闭，意味传输完成
 *  shutdownInput() :
 *  shutdownOutput() ：
 */
public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("dujunhua"),9999);
        OutputStream stream = socket.getOutputStream();
        String string = "hello Socket";
        stream.write(string.getBytes());
        //socket会关闭输出流
        socket.close();
    }
}
