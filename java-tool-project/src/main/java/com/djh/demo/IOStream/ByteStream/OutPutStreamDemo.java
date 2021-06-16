package com.djh.demo.IOStream.ByteStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamDemo {

    //通过System.getProperty获取指定的系统属性
    private static final String LINE_SEPARATOR = "line.separator";  //"line.separator"这是一个固定的字符串，不可改
    public static void main(String[] args) throws IOException {
        InPutStreamMethod();
    }

    public static void InPutStreamMethod() throws IOException {
        //也可以也成F:\FileOutPutStream.txt，   \\中的一个反斜杠是转义
        //FileOutputStream fileOutputStream = new FileOutputStream("F:\\FileOutPutStream.txt");

        FileInputStream fileInputStream = new FileInputStream("F:\\IOStreamFileDemo/FileInPutStream.txt");
        //append参数为true的话，在写入时不会覆盖写入，而是在此文件末尾写入，append默认为false
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\IOStreamFileDemo/FileOutPutStream.txt", true);

        byte[] bytes = new byte[10];
        while (fileInputStream.read(bytes)>1){
            System.out.println((new String(bytes)));  //读取文件内容
        }
        System.out.println(bytes);
        //将读出来的FileInPutStream.txt文件中的内容写入FileOutPutStream.txt
        fileOutputStream.write((new String(bytes)).getBytes());  //wirte方法只能写int类型或者byte数组，所以这里要转换成byte数组
        //fileOutputStream.write(18);   //数字无法正确写入
        fileOutputStream.write(System.getProperty(LINE_SEPARATOR).getBytes());  //换行
        fileOutputStream.write("asdf".getBytes());
        fileOutputStream.close();
        fileInputStream.close();

    }
}
