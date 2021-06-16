package com.djh.demo.Lombda.why1;

import com.djh.demo.Lombda.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码冗余，不利于扩展
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
        byAge(list);
        System.out.println("--------------------------");
        //输出符合成绩学生
        byScore(list);
    }

    public static void byAge(List<Student> students){
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge()>10){
                list.add(student);
            }
        }
        System.out.println(list);
    }
    public static void byScore(List<Student> students){
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore()>50){
                list.add(student);
            }
        }
        System.out.println(list);
    }
}
