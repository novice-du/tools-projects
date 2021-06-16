package com.djh.demo.MyTomcat;

import java.util.HashMap;

/**
 * @Author: dujunhua
 * @Create: 2021/02/22 14:32
 * @Description:
 */
public class MyMapping {

    public static HashMap<String,String> mapping = new HashMap<>();

    static {
        mapping.put("/mytomcat","com.djh.demo.MyTomcat.MyServlet");
    }

    public HashMap<String,String> getMapping(){
        return mapping;
    }
}
