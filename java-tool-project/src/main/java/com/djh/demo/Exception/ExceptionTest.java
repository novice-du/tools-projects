package com.djh.demo.Exception;

//异常的处理 ： 抛出异常

public class ExceptionTest {
    public static void show(int[] ints) throws MyException {
        if (ints == null){
            throw new NullPointerException("空指针异常");
        }
        if (ints.length<= 0){
            throw new MyException("数组下标越界异常");
        }
    }
    public static void main(String[] args) throws MyException {
        int[] arr= new int[0];
        //arr = null;
        show(arr);
    }
}
class MyException extends Exception{
    public MyException() {
    }
    public MyException(String str) {
        super(str);
    }
}