package com.djh.demo.IOStream.BufferedFileWriteRead;

import java.io.*;

public class BufferedInputAndOutPutStream {
    public static void main(String[] args) throws IOException {
        bufInputMethod();
    }
    /**
     * 使用BufferedInputStream和BufferedOutputStream操作文件的读写效率更高
     * 是带缓冲区的Reader和Writer
     * @throws IOException
     */
    //内部按一字节进行读取，读成数组，再将数组放如内存缓冲区
    public static void bufInputMethod() throws IOException {
        File file = new File("F:\\IOStreamFileDemo/FileWriter.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes  = new byte[1024];
        while ((bufferedInputStream.read(bytes))>-1){
            System.out.println(new String(bytes));
        }
        bufferedInputStream.close();
        fileInputStream.close();
    }

    //读取一个文件内容存入另一个文件
    public static void bufOutputMethod() throws IOException {
        File file = new File("F:\\IOStreamFileDemo/FileWriter.txt");
        File file2 = new File("F:\\IOStreamFileDemo/FileWriter2.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        while (bufferedInputStream.read(bytes)>-1){
            bufferedOutputStream.write(bytes);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
