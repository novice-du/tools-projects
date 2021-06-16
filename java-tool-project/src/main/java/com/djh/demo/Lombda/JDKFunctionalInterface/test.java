package com.djh.demo.Lombda.JDKFunctionalInterface;

import java.util.function.*;

/**
 * JDK提供了一些函数式接口，在使用时要主要他们的参数传递
 */
public class test {

    public static void main(String[] args) {
        //Supplier代表一个输出
        Supplier<String> supplier = ()->"你好";
        System.out.println("Supplier: "+supplier.get());

        //Consumer代表一个输入
        Consumer<Integer> consumer = (i)-> System.out.println("Consumer: "+i);
        consumer.accept(5);

        //BiConsumer代表两个输入
        BiConsumer<Integer,Integer> biconsumer = (i,j)-> System.out.println("BiConsumer; "+(i+j));
        biconsumer.accept(5,6);

        //Function代表一个输入一个输出(一般输入和输出是不同类型的)
        Function<String,Integer> function = (str)-> str.length();
        System.out.println("Function: "+function.apply("nihao"));

        //UnaryOperator代表一个输入一个输出(输入和输出是相同类型)
        UnaryOperator<Integer> unaryOperator = (i)-> i+1;
        System.out.println("UnaryOperator: "+unaryOperator.apply(5));

        //BiFunction代表两个输入一个输出(一般输入和输出是不同类型的)
        // ()中输出类型不用写,前两个是输入类型，第三个是输出类型
        BiFunction<String,String,Integer> biFunction = (str,str1)-> str.length()-str1.length();
        System.out.println("BiFunction: "+biFunction.apply("nihao", "world"));

        //代表两个输入一个输出(输入和输出是相同类型),只用写一个类型
        BinaryOperator<String> binaryOperator = (str,str1)->str+str1;
        System.out.println("BinaryOperator: "+binaryOperator.apply("nihao","world"));
    }
}
