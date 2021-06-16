package com.djh.demo.Integer;

/**
 * java中的值传递和引用传递
 * 如果传递的是基本数据类型-----值传递
 * 如果传递的是引用数据类型-----引用传递
 * String也是引用数据类型
 * String是字符串传递，String的值是不可变的
 *
 * 基本数据类型：byte  short  char  int  long  float  double  boolean
 * 包装类：Byte  Short  Character  Integer  Float  Double  Boolean
 * 转换关系：byte short char默认转换int类型
 *           int不管超不超出范围后面加上L就是long型
 *           float带有小数时默认是double类型
 *
 * 基本数据类型转成String类型1.加""; 2.valueOf()方法
 *
 *JDK5新特性
 * 自动装箱：基本数据类型-->包装类
 *          int类型可以直接赋值给包装类对象
 * 自动拆箱：包装类--> 基本数据类型
 *          包装类对象可以直接可以和基本类型进行计算
 *          直接计算时需要进行滤空操作
 */
public class IntegerDemo {
    public static void main(String[] args) {
        test();
    }
    //int范围-128到127(包含首尾)
    public static void test(){
        Integer in1 = 127;
        //相当于Integer in1 = Integer.valueOf(127);
        Integer in2 = 127;
        System.out.println(in1 == in2);  //in1和in2指向的是对象常量池中同一块内存

        Integer in3 = new Integer(127);
        Integer in4 = new Integer(127);
        System.out.println(in3 == in4);
        System.out.println(in3.equals(in4));  //Integer类重写了equals方法，比较的是值，而不是内存地址

        Integer in5 = 128;              //Java虚拟机提供了缓冲池(对象常量池)，Double和float类型除外
        Integer in6 = 128;              //缓冲池有大小，一个字节
        System.out.println(in5 == in6);  //当超过范围时，不会用到对象常量池，而是直接开辟新的内存地址

        Integer in7 = new Integer(128);
        Integer in8 = new Integer(128);
        System.out.println(in7 == in8);
        System.out.println(in7.equals(in8));
    }
}
