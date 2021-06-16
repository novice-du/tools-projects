package com.djh.demo.Lombda.why4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:dujunhua
 * @Date:2020/9/24 20:58
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");

        list.forEach(System.out::println);
    }
}
