package com.djh.demo.Collection.SetDemo;

import java.util.TreeSet;

/**
 *TreeSet:底层实现是treeMap,内是红黑树数据结构   不同步的
 * 默认是对元素按照自然顺序排序(1234、abcd)
 *
 * 在存对象时，两种方法进行排序
 * 一：内部实现Comparable方式：定义在元素的类中
 * 二：外部定义比较器方式（实现Comparator< >）: 定义在当前类中(这种方式更灵活)
 *
 * 外部比较器可以定义成一个工具类，此时所有需要比较的规则如果一致的话，可以复用，
 * 而内部比较器只有在存储当前对象的时候才可以使用
 *
 * 如果两者同时存在，会使用外部比较器。当使用比较器的时候，就不会调用equals方法。
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        method3();
    }
    public static void method(){
        TreeSet treeSet = new TreeSet();
/*        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(3);*/

        treeSet.add("c");
        treeSet.add("a");
        treeSet.add("d");
        treeSet.add("b");
        System.out.println(treeSet);
    }
    //内部比较
    public static void method2(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(new PersonOfTreeSet(10,"张三"));
        treeSet.add(new PersonOfTreeSet(20,"李四"));
        treeSet.add(new PersonOfTreeSet(10,"张小三"));
        System.out.println(treeSet);
    }
    //外部比较
    public static void method3(){
        TreeSet treeSet = new TreeSet(new CompareByAgeAndName());
        treeSet.add(new PeopleOfTreeSet(10,"张三"));
        treeSet.add(new PeopleOfTreeSet(20,"李四"));
        treeSet.add(new PeopleOfTreeSet(10,"张小三"));
        System.out.println(treeSet);
    }
}
