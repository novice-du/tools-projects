package com.djh.collection.ListDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ArrayList去重复数据练习
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(10);

        List newList = new ArrayList<Integer>();
        //Collections.sort(list);       //Collections.sort方法可以让集合按自然顺序排序

/*        int[] arr = {5,1,2,45,6,8};
        Arrays.sort(arr);               //Arrays.sort方法也可以将数组进行自然排序
        for (int i : arr) {
            System.out.println(i);
        }*/
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            Integer next = (Integer) iterator.next();
            if (!newList.contains(next)) {
                newList.add(next);
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            System.out.println("不重复的集合：" + newList.get(i));
        }
    }

}
