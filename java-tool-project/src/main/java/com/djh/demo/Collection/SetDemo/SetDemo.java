package com.djh.demo.Collection.SetDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set：无序的，不可重复的集合（满足e1.equals(e2)）且最多只能有一个null元素        不同步的
 *hashcode() equals()
 * 只有hashcode值相同时才会执行equals，如果x.equals(y) == true，那么他们的hashcode值一定相同
 *
 * HashSet： 内部是哈希表数据结构，允许有null值，类中没有提供根据集合索引获取索引对应的值的方法      不同步的
 * 因此遍历HashSet时需要使用Iterator迭代器
 */
public class SetDemo {
    public static void main(String[] args) {
        SetDemo();
    }

    public static void SetDemo(){
        Set set = new HashSet();
        set.add(12);          //String类不可被继承
        set.add(10);
        set.add(17);
        set.add(5);
        set.add(21);
        System.out.println(set);
    }
    public static void SetDemo2(){
        Set set = new HashSet();
        set.add(new Person(1,"张三"));    //如果想要判定年龄和名字相同为同一个人
        set.add(new Person(1,"张三"));    //那么要在Person中重写hashCode和equals方法
//        set.add(new Person(2,"李四"));
//        set.add(new Person(2,"王五"));
//        set.add(new Person(3,"赵六"));
//        set.add(new Person(1,"赵六"));


        System.out.println(set);
    }
}
