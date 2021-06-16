package com.djh.demo.Lombda.MethodReference;

import java.util.function.Consumer;

/**
 * 实例方法的引用
 */
public class InstanceDemo {

    public String print(String str){
        return str;
    }

    public static void main(String[] args) {
        InstanceDemo instanceDemo = new InstanceDemo();

        Consumer<String> consumer = (str)->new InstanceDemo().print(str);
        consumer.accept("nihao");

        Consumer<String> consumer2 = new InstanceDemo()::print;
        consumer2.accept("nihao2");

        Consumer<String> consumer3 = instanceDemo::print;
        consumer3.accept("nihao3");
    }
}
