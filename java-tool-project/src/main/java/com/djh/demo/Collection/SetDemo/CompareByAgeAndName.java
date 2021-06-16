package com.djh.demo.Collection.SetDemo;

import java.util.Comparator;

//第一种是通过implements Comparable，重写compareTo，内部比较
//此方法属于自定义比较器，通过自定义一个类，实现Comparator并重写compare方法
public class CompareByAgeAndName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        PeopleOfTreeSet perople = (PeopleOfTreeSet) o1;
        PeopleOfTreeSet perople2 = (PeopleOfTreeSet) o2;
        int temp = perople.getAge() - perople2.getAge();
        int compare = perople.getName().compareTo(perople2.getName());
        return temp == 0?compare:temp;
    }
}
