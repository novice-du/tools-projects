package com.djh.demo.Lombda.why4;

import com.djh.demo.Lombda.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 摆脱匿名内部类，通过lombda使代码更简洁
 */
public class Test {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("zhangsan",11,50));
        list.add(new Student("lisi",20,70));
        list.add(new Student("wangwu",8,10));
        list.add(new Student("zhaoliu",15,90));
        list.add(new Student("maqi",5,20));
        list.add(new Student("zhouba",17,30));
        //输出符合年龄学生
        byFilter(list,(e)->e.getAge()>15);
        System.out.println("--------------------------");
        //输出符合成绩学生
        byFilter(list,(e)->e.getScore()>50);
    }
    //比较
    public static void byFilter(List<Student> students , Compare compare){
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (compare.compare(student)) {
                list.add(student);
            }
        }
        print(list);
    }
    //输出
    public static void print(List<Student> students){
        System.out.println(students);
    }
}
