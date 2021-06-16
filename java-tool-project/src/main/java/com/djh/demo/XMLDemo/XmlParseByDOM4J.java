//package com.djh.demo.XMLDemo;
//
//import com.djh.demo.XMLDemo.Entity.Person;
//import org.dom4j.*;
//import org.dom4j.io.SAXReader;
//import org.junit.Test;
//
//import javax.swing.text.Document;
//import javax.swing.text.Element;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.List;
//
///**
// * 通过DOM4J解析XML文件
// */
//public class XmlParseByDOM4J {
//    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
//        parseXml();
//    }
//    public static void parseXml() throws FileNotFoundException, DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        SAXReader saxReader = new SAXReader(); //用来读取文件
////        Document document = saxReader.read(new File("src/text.xml"));
//        Document document = (Document) saxReader.read("src/text.xml");
//        //获取xml文件的根节点
//        Element element = document.getRootElement();
//        //根据根节点获取其子节点集合
//        List<Element> eList = element.elements();
//        if (eList!=null){
//            for (Element el : eList){
//                String idVal = el.element("bean").attributeValue("id");
//                String nameVal = el.element("bean").attributeValue("name");
//
//                if ("com.djh.demo.XMLDemo.Entity.Person".equals(nameVal)){
//                    Class<?> aClass = Class.forName(nameVal);
//                    Person person = (Person) aClass.newInstance();
//                    person.show();
//                }
//            }
//        }
//    }
//}
