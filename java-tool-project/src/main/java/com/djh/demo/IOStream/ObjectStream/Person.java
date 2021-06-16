package com.djh.demo.IOStream.ObjectStream;

import lombok.*;

import java.io.Serializable;

/**
 * 什么是序列化：它是处理对象流的一种机制，即可以很方便的保存内存中java对象的状态，同时也为了方便传输。
 * 序列化：把对象转换为字节序列的过程称为对象的序列化。
 * 反序列化：把字节序列恢复为对象的过程称为对象的反序列化。
 * 当你想把的内存中的对象状态保存到一个文件中或者数据库中时候会用到序列化。
 *
 * 注意事项：
 * 当一个父类实现序列化，子类自动实现序列化，不需要显式实现Serializable接口；
 * 当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {
    private static final long serialVersionID = -123456L;
    private int age;
    private String name;
    //对象的默认序列化机制写入的内容是：对象的类、类签名、以及非瞬态和非静态字段的值
    //其他对象的引用（瞬态和静态字段除外），也会导致写入那些对象
    // static静态的和transient瞬态的（短暂的），transient可以用来修饰密码之类的属性
    private static String sex;
    private transient String card;
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

}
