package com.djh.demo.IOStream.BufferedFileWriteRead;

import java.io.*;

/**
 * 通过缓冲区读写字符流
 */
public class BufferedFileWriteReadLine {

    public static void main(String[] args) throws IOException {
//        writerLine();
        readerLine();
    }

    //写文件
    public static void writerLine() throws IOException {
        FileWriter fw = new FileWriter("F:\\IOStreamFileDemo/BufferedWriter.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("张三");
        //换行
        bw.newLine();
        bw.write("李四");
        bw.close();
        fw.close();
    }

    //字符流一行一行读
    public static void readerLine() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("F:\\IOStreamFileDemo/BufferedWriter.txt");
            br = new BufferedReader(fr);
            String s = null;
            while ((s = br.readLine()) != null) {    //在这里会一行一行读
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {      //这里要进行一个异常捕获，br如果为空抛出异常，finally块依然会执行，如果不
                    br.close();         //捕获，那么在关闭操作是，br为空，也会出现异常
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
