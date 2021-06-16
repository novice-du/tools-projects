package com.djh.demo.Generic;

/**
 * 泛型接口实现类
 */
public class DenericDemo2Impl implements DenericDemo2<String> {


    @Override
    public String test() {
        return null;
    }

    @Override
    public void test2(String s) {
        System.out.println("s :"+s);
    }
}
