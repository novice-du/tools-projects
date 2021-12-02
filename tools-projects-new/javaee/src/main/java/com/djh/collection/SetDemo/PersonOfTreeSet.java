package com.djh.collection.SetDemo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
/**
 * 在此必须实现Comparable接口，重写compareTo方法
 * 否则在TreeSet集合中添加PersonOfTreeSet对象时，
 * 会出现类型转换异常：PersonOfTreeSet不能转换为Comparable
 *
 * 此比较方法（通过implements Comparable，重写compareTo）属于内部实现
 */
public class PersonOfTreeSet implements Comparable {
    private int age;
    private String name;

    /**
     * 比较此对象与指定对象的顺序，如果该对象小于、等于或大于该对象，
     * 则分别返回负整数、零或正整数
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        PersonOfTreeSet person = (PersonOfTreeSet) o;
        System.out.println("this.age = " + this.age + " " + "person.age = " + person.age);
        int temp = this.age - person.age;
        //判断年龄如果相等的话名字是否相同
        return temp == 0 ? this.name.compareTo(person.name) : temp;
        //return 0;   //因为Set集合不允许存重复，所以当返回0时，只能存一个对象
    }
}
