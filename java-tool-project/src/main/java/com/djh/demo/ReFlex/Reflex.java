package com.djh.demo.ReFlex;

import com.djh.demo.ReFlex.Entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：
 * java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法;
 * 对于任何一个对象，都能够调用它的任意一个方法和属性;
 * 这种动态获取信息以及动态调用对象的方法的功能成为java语言的反射机制
 *
 * Class没有公共构造方法，Class对象是在加载类时由java虚拟机以及通过调用类加载器中
 * 的defineClass方法自动构建的
 */
public class Reflex {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        getCls1();
//        getReflex();
//        getReflex2();
//        getReflex3();
        getReflex4();
    }
    //通过创建对象
    public static void getCls1(){
        Person person = new Person(12,"zhangsan");
        Person person1 = new Person(12,"zhangsan");
        System.out.println(person == person1);   //为false

        Class<? extends Person> aClass = person.getClass();  //一个类只能获取一个Class文件
        Class<? extends Person> aClass1 = person1.getClass(); //通过对象获取类型类
        System.out.println(aClass == aClass1);      //true

        Class<Person> aClass2 = Person.class;
        Class<Person> aClass3 = Person.class;
        System.out.println(aClass2 == aClass3);  //通过类名获取类型类
    }
    //通过反射
    public static void getReflex() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.djh.demo.ReFlex.Entity.Person");//返回与给定字符串名称的类或接口相关联的类对象
        Constructor<?>[] cons = aClass.getConstructors();  //返回一个Constructor对象，它反映此Class对象所表示的类的指定公共构造方法(私有的无法获取)
        for (Constructor con:cons) {
            System.out.println(con);    //打印构造器
        }
        Person person = (Person) aClass.newInstance();   //newInstance方法，创建由此类对象表示的类的新实例
        person.show();
    }
    //获取有参构造器
    public static void getReflex2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.djh.demo.ReFlex.Entity.Person");
        //获取指定的公共构造器
        Constructor<?> con = aClass.getConstructor(int.class, String.class);
        Person person = (Person) con.newInstance(12, "zhangsan");  //传入参数
        person.show();
    }
    //获取到所有的构造器(包括私有构造器)
    public static void getReflex3() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.djh.demo.ReFlex.Entity.Person");
        Constructor<?>[] cons = aClass.getDeclaredConstructors();    //获取到所有的构造器(包括私有构造器)
        for (Constructor con:cons) {
            System.out.println(con);
        }
    }
    //拿到所有的公共方法
    public static void getReflex4() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.djh.demo.ReFlex.Entity.Person");
        Method[] methods = aClass.getMethods();     //拿到所有的公共方法（java8不包含构造器）
        for(Method method: methods){
            System.out.println(method);
        }
    }
}
