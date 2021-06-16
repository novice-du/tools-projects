package com.djh.demo.Lombda.MethodReference;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 静态方法的引用
 * 用法:  类名::staticMethod
 *        (args)->类名.staticMethod(args)
 */
public class StaticDemo {
    
    static String print(){
        return "nihao";
    }

    public static void main(String[] args) {
        Supplier<String> supplier = ()->StaticDemo.print();
        System.out.println(supplier.get());

        Supplier<String> supplier1 = StaticDemo::print;
        System.out.println(supplier1.get());

        BiFunction<String,String,Integer> biFunction = StaticDemo2::print;
        biFunction.apply("nihao","world");
    }
}

class StaticDemo2{

    static Integer print(String str,String str2){
        return str.length()-str2.length();
    }

}