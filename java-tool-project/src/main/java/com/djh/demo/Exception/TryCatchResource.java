package com.djh.demo.Exception;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Try-with-resources是Java7中一个新的异常处理机制，它能够很容易地关闭在try-catch语句块中使用的资源
 * 实现了 java.lang.AutoCloseable/java.io.Closeable 的类对象,可以用于try-with-resources
 */
public class TryCatchResource {

    //通过普通try/catch写读文件操作
    public static void method1(){
        FileReader fr = null;
        try {
            fr = new FileReader("F:\\IOStreamFileDemo/FileWriter.txt");
            char[] chars = new char[4];
            if ((fr.read(chars))>-1){
                System.out.println(new String(chars));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                    System.out.println("fr已关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 当try语句块运行结束时，FileReader 会被自动关闭。这是因为FileReader
     * 实现了java中的java.lang.AutoCloseable接口。所有实现了这个接口的类都可以在try-with-resources结构中使用
     *
     * try块里面和close函数都可能抛出异常，这里会将try块抛出的异常压缩成Suppressed Exceptions，
     * 可以调用Throwable.getSuppressed方法取出被抑制的异常
     * 这在finally语句块中关闭资源相反（close函数抛异常，如果抛出异常，try块里面的异常信息就会被丢弃）
     *
     * 可以在块中使用多个资源而且这些资源都能被自动地关闭，且会以创建的顺序的逆序来关闭
     */
    //使用try/catch/resource
    public static void method2(){
        try (FileReader fr = new FileReader("F:\\IOStreamFileDemo/FileWriter.txt")){
            char[] chars = new char[4];
            if (fr.read(chars)>-1){
                System.out.println(chars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        method2();
    }

}
