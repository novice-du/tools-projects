package com.djh.demo.Net.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  使用TCP接收数据
 *  1. 创建监听Socket对象
 *  2。监听(阻塞)
 *  3. 获取输入流对象
 *  4. 输出数据
 *  5. 释放资源
 *  ServerSocket接收端，服务端Socket
 *
 *  服务端在接收完数据后可以对数据进行处理，然后通过输出流再将数据返回给客户端
 *  客户端再通过输入流接收数据。流程无变化。
 */
public class TCPServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        //ServerSocket不能获取输入流输出流。所以需要将其转成Socket对象
        Socket accept = socket.accept();
        InputStream stream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        len = stream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //关闭Socket对象和ServerSocket
        System.out.println(accept.getInetAddress().getHostName());
        accept.close();
        //socket.close();
    }
}
