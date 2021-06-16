package com.djh.demo.Generic;

/**
 * 泛型方法
 */
public class DenericDemo3<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <Q> void show(Q q){
        System.out.println(q);
        System.out.println(t);
    }

}
