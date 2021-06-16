package com.djh.demo.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection主要方法：
 * 1. boolean add(Object o)  添加一个元素
 * 2. boolean add(Collection c)   添加一个Collection集合
 * 3. boolean remove(Object o)   删除一个元素，若集合有多个o元素，则只会删除第一个元素
 * 4. boolean removeAll(Collection c)   删除另一个集合和这个集合的相同元素
 * 5. int size();   集合的元素个数
 * 6. boolean isEmpty()   判断集合的元素size是否为0
 * 7. void clear()   清空所有元素
 * 8. boolean contains(Object o)  判断集合中是否包含对象o
 * 9. boolean containsAll(Collection c)  判断指定集合是否包含集合c的所有元素
 * 10. boolean retainAll(Collection c)   从指定集合中保留包含集合c的元素,其他元素则删除
 * 11. T[] toArray(T[] a)   将集合转换为T类型的数组
 */

public class CollectionDemo {
    public static void main(String[] args) {
       // collDemo();
        collIteratorDemo();
    }
    public static void collDemo(){
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add("D");
        coll.add("J");
        Collection coll2 = new ArrayList();
        coll2.add(1);
        coll2.add("L");
        coll2.add("J");
        coll.addAll(coll2);
        System.out.println("添加后的coll"+coll);
        System.out.println("添加后的coll2"+coll2);
        coll.removeAll(coll2);
        System.out.println("删除后"+coll);
    }

    //Collection集合中是否包含某元素，有的话打印出来
    public static void collIteratorDemo(){
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add("D");
        coll.add("J");
        //Iterator在遍历过程中只能删除元素，不能添加元素，否则会报并发修改错误
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            if (object == "D"){
                //coll.remove(object);
                System.out.println(object);
            }
        }

    }
}
