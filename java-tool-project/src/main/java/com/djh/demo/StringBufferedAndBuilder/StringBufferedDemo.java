package com.djh.demo.StringBufferedAndBuilder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * string  stringbuff stringbuild的执行效率： stringbuild>stringbuff>string
 * String类是不可变类，任何对String的改变都会引发新的String对象的生成；
 * StringBuffer是可变类，任何对它所指代的字符串的改变都不会产生新的对象，线程安全的。
 * StringBuilder是可变类，线性不安全的，不支持并发操作，不适合多线程中使用，但其在单线程中的性能比StringBuffer高。
 *
 * 栈：存放基本类型的变量数据和对象的引用。
 *     像int a = 1;  String str = "hello" ; String str1 = new String("OK") ;  栈中存放的是 a, 1, str, str1。
 *
 * 常量池：存放基本类型常量和字符串常量。
 *
 * 堆：存放所有new出来的对象。
 *
 * 栈中的数据大小和生命周期是可以确定的，当没有引用指向数据时，这个数据就会自动消失。
 * 堆中的对象的由垃圾回收器负责回收，因此大小和生命周期不需要确定，具有很大的灵活性。
 *
 * 而对于字符串来说，其对象的引用都是存储在栈中的，如果是编译期已经创建好（即指用双引号定义的）的
 * 就存储在常量池中，如果是运行期（new出来的对象）则存储在堆中。对于equals相等的字符串，在常量池中是只有一份的，
 * 在堆中则有多份
 *
 */
public class StringBufferedDemo {
    public static void main(String[] args) throws IOException {
        bufferedDemo();
    }
    public static void bufferedDemo() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\IOStreamFileDemo/FileInPutStream.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        InputStreamReader isr = new InputStreamReader(bis);
        char[] chars = new char[1024];
        StringBuffer sb = new StringBuffer();
        while (isr.read(chars)>-1){
            sb.append(chars);     //append方法是在末尾添加
        }
        System.out.println(sb.toString());
        isr.close();
        fis.close();
    }
}
