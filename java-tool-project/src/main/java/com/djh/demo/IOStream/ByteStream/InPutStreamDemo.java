package com.djh.demo.IOStream.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 按流向区分：
 * 输入流、输出流
 * InputStream（抽象类）:此抽象类是表示字节输入流的所有类的超类
 * OutPutStream（抽象类）:此抽象类是表示字节输出流的所有类的超类
 *
 * 按照处理单元划分:
 * 字节流、字符流
 * Writer（抽象类）:用于写入字符流的抽象类
 * reader（抽象类）:用于读取字符流的抽象类
 */
public class InPutStreamDemo {

    public static void main(String[] args) throws IOException {
        InPutStreamMethod();
    }

    public static void InPutStreamMethod() throws IOException {
        FileInputStream inputStream = new FileInputStream("F:\\IOStreamFileDemo/FileInPutStream.txt");
        //System.out.println((char) inputStream.read());   //仅能读取一个字节
        //每次一字节进行读取
/*        int in = 0;
        while ((in = inputStream.read())>-1){           //reade方法返回下一个数据字节，如果达到文件末尾，则返回-1
            System.out.println((char) in);
        }*/

        //inputStream.available()返回下一次对此输入流调用的方法可以不受阻塞地从输入流读取（或跳过）的估计剩余字节数
        //如果要读取的文本过大，则该方法不适用
        //byte[] bytes = new byte[inputStream.available()];

        //通过缓冲区读取  提高效率
        //byte[] bytes = new byte[3];
        byte[] bytes = new byte[1024];  //通常写1024（字节），相当于1kb
        int in2 = 0;
        while ((in2 = inputStream.read(bytes))>-1){
           // System.out.println(in2);   //这里返回的是读入缓冲区的字节总数，如果达到文件末尾，则返回-1
            System.out.println(new String(bytes));   //new String(bytes)  将一个字节数组转换成字符串
        }
        inputStream.close();
    }
}
