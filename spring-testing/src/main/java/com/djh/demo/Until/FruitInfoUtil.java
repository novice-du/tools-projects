package com.djh.demo.Until;

import com.djh.demo.Service.FruitColor;
import com.djh.demo.Service.FruitName;
import com.djh.demo.Service.FruitProvider;

import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){

        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvicer="供应商信息：";
        //clazz.getDeclaredFields(): 返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 类对象
        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            //A.isAnnotationPresent(B.class)
            //意思是:注解B是否在此A上。如果在则返回true；不在则返回false
            if(field.isAnnotationPresent(FruitName.class)){
                //field.getAnnotation():
                //方法如果存在这样的注释，则返回指定类型的元素的注释，否则为null
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}