package com.djh.demo.Generic;

/**
 * 泛型类
 */
public class DenericDemo1<T> {

    private int age;
    private T t;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "DenericDemo1{" +
                "age=" + age +
                ", t=" + t +
                '}';
    }
}
