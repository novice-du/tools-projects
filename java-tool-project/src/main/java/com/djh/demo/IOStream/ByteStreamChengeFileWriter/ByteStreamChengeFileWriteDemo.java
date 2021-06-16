package com.djh.demo.IOStream.ByteStreamChengeFileWriter;

import java.io.*;

/**
 * 字节流与字符流的转换
 * InputStreamReader : 是字节流通向字符流的桥梁，
 * OutputStreamWriter ：是字符流通向字节流的桥梁
 */
public class ByteStreamChengeFileWriteDemo {
    public static void main(String[] args) throws IOException {
        method();
    }
    //字节流转换成字符流读取
    public static void method() throws IOException {

        FileInputStream is = new FileInputStream("F:\\IOStreamFileDemo/FileInPutStream.txt");
        BufferedInputStream bis = new BufferedInputStream(is);
        InputStreamReader isr = new InputStreamReader(bis);
        char[] chars = new char[1024];
        while (isr.read(chars) > -1) {
            System.out.println(chars);
        }
    }
    //字符流转字节流
    public static void method2() throws IOException {
        FileReader fr = new FileReader("F:\\IOStreamFileDemo/FileWriter");
        BufferedReader br = new BufferedReader(fr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        char[] chars = new char[1024];
        String str = null;
        while ((str = br.readLine())!= null){

        }

    }
}
