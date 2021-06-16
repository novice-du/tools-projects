package com.djh.demo.IOStream.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 该类的实例支持读取和写入随机访问文件。 随机访问文件的行为类似于存储在文件系统中的大型byte数组
 * 存在指向该隐含数组的光标或索引，成为文件指针
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        readMethod();
    }
    public static void writerMethod() throws IOException {
        RandomAccessFile rf = new RandomAccessFile("F:\\IOStreamFileDemo/RandomAccessFile.txt", "rw");  //"rw"表示文件若不存在，则创建
        rf.write("zhangsan".getBytes());  //正常写入
        rf.write("lisi".getBytes());  //正常写入
//        rf.write("wangwu".getBytes());  //已写入的内容只要不删除就一直存在
//        rf.writeChars("wangwu");  //双字节写入
        rf.write(1);
        rf.writeInt(97);   //按四字节写入
        rf.close();
    }
    public static void readMethod() throws IOException {
        RandomAccessFile rf = new RandomAccessFile("F:\\IOStreamFileDemo/RandomAccessFile.txt", "rw");
        System.out.println(rf.read());  //读第一个字节值
        //rf.getFilePointer();   //当前指针位置
        rf.skipBytes(2);       //跳过2个字节数
        System.out.println(rf.read());
        rf.seek(5);  //设置指针位置
        rf.close();
    }
}
