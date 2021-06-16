package com.djh.demo.Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress: 此类表示互联网协议(IP)地址
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("dujunhua");
        InetAddress byName1 = InetAddress.getByName("192.168.124.32");
        //getLocalName();   //获取本地主机名
        System.out.println(byName);
        System.out.println(byName1.getHostAddress()); //返回IP地址
        System.out.println(byName1.getHostName()); //返回主机名
    }
}
