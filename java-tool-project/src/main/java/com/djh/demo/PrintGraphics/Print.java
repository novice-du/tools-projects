package com.djh.demo.PrintGraphics;

import org.junit.Test;

//打印图形
public class Print {
    @Test
    public static void main(String[] args) {
        printRightTriangle(5);
    }

    //打印等腰三角形(尖向上)
    public static void printTriangle(int n){
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <=n-i ; k++)
                System.out.print(" ");
            for (int j = 1; j <=2*i-1 ; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    //打印一个直角三角形
    public static void printRightTriangle(int n){
        for (int i= 1; i < n; i ++){
            for (int j = 1; j <i+1; j ++)
                System.out.print("*");
            System.out.println();
        }
    }
}
