package com.djh.demo.Lombda.MethodReference;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * 构造方法引用
 * 用法: 类名::new
 */
public class ContructorDemo {

    public static void main(String[] args) {

        Supplier<Person> supplier = ()->new Person();
        supplier.get();

        BiConsumer<String ,Integer> biConsumer2 = Person::new;
        biConsumer2.accept("zhangsan",10);
    }
}

class Person{

    private String name;

    private int age;

    public Person() {
        System.out.println("无参构造函数");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name+age);
    }
}