package com.djh.demo.Exam;

public class test {
    public static void main(String[] args) {
        te(10);
//        meth();
    }

    public static void te(int n){
        int start = 3;
        int[] in = new int[n];
        in[0] = 3;
        for (int i = 1; i < in.length; i++) {
            in[i] = start*i+3;
        }
        int num = 0;
        for (int x:in) {
            if (x%9==0){
                num+=x;
            }
        }
        System.out.println(num);
    }
    public static void meth(){
        int num = 66;
        num = 666;
        String st = "hello";
        funch(num);
        System.out.println(num);
    }
    public static void funch(int num){
        num = 55;
        System.out.println(num);
    }
}
