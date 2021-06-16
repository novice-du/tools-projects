package com.djh.demo.Collection.ListDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * List：
 * ArrayList:  内部是数组结构，不同步的    也可称为动态数组
 * LinkedList:  内部是链表结构，不同步的
 * Vector:    内部是数组结构，同步的
 */
public class ArrayListDemo {

    public static void main(String[] args) {
//        listTest();
//        listTest2();
        listTest3();
    }

    //基本语法
    public static void listTest() {
        List list = new ArrayList();
        list.add(4);
        list.add(5);
        list.add("6");
        List list1 = new ArrayList();
        list1.add("D");
        list1.add("J");
        list1.add("H");
        list.add(1, list1);
        //list.addAll(1,list1);   //如果是addAll添加的话，则list1在list中不是整体
        System.out.println("添加元素后的list" + list);
        System.out.println("list集合长度" + list.size());
        System.out.println("查询该值在集合中的下标" + list.indexOf(list1));  //查询对象所在集合中的下标
        List list2 = list.subList(1, list.size());  //返回集合中fromIndex（包括）到toIndex（不包括）中间的内容
        System.out.println(list2);
    }

    //迭代器遍历集合
    public static void listTest2(){
        List list = new ArrayList();
        list.add(4);
        list.add(5);
        list.add("6");
        //ListIterator是Iterator的子类，可以在遍历的过程中添加元素
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {       //从前往后遍历
            System.out.println("从前往后遍历:  "+iterator.next());
        }
        while (iterator.hasPrevious()) {         //从后往前遍历
            System.out.println("从后往前遍历"+iterator.previous());
        }
        while (iterator.hasNext()) {     //iterator.nextIndex()下一个元素的索引
            System.out.println(iterator.next() + "--index--" + iterator.nextIndex());
        }
        while (iterator.hasPrevious()) {     //iterator.previousIndex()上一个元素的索引
            System.out.println(iterator.previous() + "--index--" + iterator.previousIndex());
        }
    }
    //List集合转换为数组
    public static void listTest3(){
        List list = new ArrayList();
        list.add(4);
        list.add(5);
        list.add("6");

        Object[] objects = list.toArray();  //toArray()方法将集合转换为数组
        for (Object ob : objects) {
            System.out.println(ob);
        }

        //判断集合中是否包含String类型的值，如果有，打印出来
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()){
            Object ob = iterator.next();
            if (ob instanceof String){  //instanceof判断的是：你属于该类或者该类的派生类吗
                System.out.println(ob+"是String类或String类的派生类");
            }
        }
    }

}
