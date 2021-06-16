package com.djh.demo.IOStream.FileWriter;

import java.io.*;

/**
 * 字符流
 */
public class FileWriterAndReaderDemo {

    public static void main(String[] args) throws IOException {
        fileWriterMethod();
//        fileDeaderMethod();

    }
    //写入操作
    public static void fileWriterMethod() throws IOException {
        //new FileWriter时会在本地自动创建文件，如果本地有同名文件，将会覆盖文件
        //如果append为false，在本地改动了文件内容，执行程序时会覆盖原文件
        //如果append为true，执行程序时，会在本地文件内容后追加新内容
        FileWriter fileWriter = new FileWriter("F:\\IOStreamFileDemo/FileWriter.txt",true);
        fileWriter.write("张大三");   //只是调用write方法，不会把数据写入文件中，而是写入缓冲区中
        //fileWriter.flush();           //调用flush方法，数据才会进入到文件中
        fileWriter.write("lisi");
        //fileWriter.flush();
        fileWriter.write("王大五");
        //fileWriter.flush();
        fileWriter.close();  //在流关闭前会进行一次flush操作
    }
    //读取操作
    public static void fileDeaderMethod() throws IOException {
        FileReader fileReader = new FileReader("F:\\IOStreamFileDemo/FileWriter.txt");
        char[] chars = new char[4];
        while (fileReader.read(chars)>-1){
            System.out.println(new String(chars));
        }
    }

}
