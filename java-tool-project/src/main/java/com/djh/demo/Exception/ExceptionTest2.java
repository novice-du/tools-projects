package com.djh.demo.Exception;


public class ExceptionTest2 {
    public static void num(){
        int[] num = new int[3];
        System.out.println(num.length);
    }

    public static void main(String[] args) {
        try {
            num();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
