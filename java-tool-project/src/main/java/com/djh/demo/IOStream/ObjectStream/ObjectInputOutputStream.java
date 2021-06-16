package com.djh.demo.IOStream.ObjectStream;

import java.io.*;

public class ObjectInputOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //WriterObject();
        ReaderObject();
    }
    //写入一个对象
    public static void WriterObject() throws IOException {
        File file = new File("F:\\IOStreamFileDemo/Object.object"); //存放类的话，后缀应该是.object
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person person = new Person(12,"adads");
        oos.writeObject(person);
        oos.close();
        fos.close();
    }
    //读对象
    public static void ReaderObject() throws IOException, ClassNotFoundException {
        File file = new File("F:\\IOStreamFileDemo/Object.object");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person  = (Person) ois.readObject();   //转成person类型
        System.out.println(person.getAge()+person.getName());
        ois.close();
        fis.close();
    }
}
