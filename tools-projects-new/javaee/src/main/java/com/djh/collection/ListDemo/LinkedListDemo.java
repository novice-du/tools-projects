package com.djh.collection.ListDemo;

import java.util.LinkedList;

/**
 * List：
 * ArrayList:  内部是数组结构，不同步的
 * LinkedList:  内部是链表结构，不同步的
 * Vector:    内部是数组结构，同步的
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedDemo();
    }

    //更多方法，详见API
    public static void LinkedDemo() {
        LinkedList list = new LinkedList();
        //在列表最后添加元素
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        //在列表开头添加元素
        list.addFirst(0);
        list.addFirst(-1);
        System.out.println(list);
        //获取第一个元素
        list.element();
        //获取但不移除此列表的第一个元素，如果此列表为空，返回null；
        list.peekFirst();
        //获取但不移除此列表的最后一个元素，如果此列表为空，返回null；
        list.peekLast();
        //获取并移除此列表的第一个元素，如果此列表为空，返回null；
        list.pollFirst();
        //获取并移除此列表的最后一个元素，如果此列表为空，返回null；
        list.pollLast();
        System.out.println(list);
    }
}
