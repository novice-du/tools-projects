package com.djh.demo.ReFlex.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int age;
    private String name;

    private Person(int age){
        this.age = age;
    }
    public void show(){
        System.out.println("========show========"+age+"  "+name);
    }
    private void show1(){
        System.out.println("========show========"+age+"  "+name);
    }
}
