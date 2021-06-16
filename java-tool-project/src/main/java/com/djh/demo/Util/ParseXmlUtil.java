package com.djh.demo.Util;

import com.djh.demo.XMLDemo.Entity.Person;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.*;

/**
 * DOM4J解析XML工具类
 */
public class ParseXmlUtil {
    public static void main(String[] args) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = "src/text.xml";
        Class cls = getClassById(path, "personId");
        Person person = (Person) cls.newInstance();
        person.show();
    }
    //private static Map<String,String> map  = null; //不能这样定义，map虽然初始化了，但是成员变量默认初始化为null，并没有分配内存
    private static Map<String,String> map  = new HashMap<>();  //要写上new HashMao<>();否则会报空指针异常
    private static Class aClass = null;
    //通过传入的xml文件路径，获取含节点属性map
    public static Map<String,String> getAttributeMap(String path) throws DocumentException {
        SAXReader saxReader = new SAXReader(); //用来读取文件
        Document document = saxReader.read(path);   //读取传进来的路径文件
        //获取xml文件的根节点
        Element element = document.getRootElement();
        //根据根节点获取其子节点集合
        List<Element> eList = element.elements();
        if (eList!=null){
            for (Element el : eList){
                String idVal = el.element("bean").attributeValue("id");
                System.out.println("idVal   "+idVal);
                String nameVal = el.element("bean").attributeValue("name");
                System.out.println("nameVal   "+nameVal);
                map.put(idVal,nameVal);   //将所有属性的Key，Value保存在一个map中
                System.out.println("====="+map);

            }
        }
        return map;
    }
    //通过ID获取Class对象
    public static Class getClassById(String path,String id) throws ClassNotFoundException, DocumentException {
        map = getAttributeMap(path);
        if (map!=null){
            Set<String> keys = map.keySet();    //将所有key保存在一个Set集合中
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                if (id.equals(key)){
                    String val = map.get(key);
                    aClass = Class.forName(val);
                    return aClass;
                }
            }
        }
        return aClass;
    }

}
