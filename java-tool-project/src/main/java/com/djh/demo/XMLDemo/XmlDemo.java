package com.djh.demo.XMLDemo;

import com.djh.demo.XMLDemo.Entity.Person;
import org.dom4j.DocumentException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 前后台交互的两种方式：
 * Json
 * XML：解析方式：
 *      DOM：
 *      SAX：
 *      JDOM：简化与XML的交互并且比使用DOM实现更快,仅使用具体类而不使用接口因此简化了API,并且易于使用
 *      DOM4J：是JDOM的一种智能分支，功能强大
 */
public class XmlDemo {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException,
            IllegalAccessException, InstantiationException, ClassNotFoundException, DocumentException {
        getObj() ;
    }
    //DOM解析XML
    public static void getObj() throws ParserConfigurationException, IOException, SAXException,
                            ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取document创建工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //获取能够创建document的对象---documentBuilder
        DocumentBuilder db = dbf.newDocumentBuilder();
        //获取document对象
        Document document = db.parse(new FileInputStream(new File("src/text.xml")));
        //获取指定标签元素
        NodeList nodelist = document.getElementsByTagName("bean");
        //获取对应的元素对象
        Node node = nodelist.item(0);
        //拿到对应的属性和值得集合
        NamedNodeMap nnm = node.getAttributes();    //attribute（属性）
        if (nnm!=null){
            for (int i = 0; i < nnm.getLength(); i++) {
                Attr attr = (Attr) nnm.item(i);     //节点转换成具体的属性
                String key = attr.getName();
                String value = attr.getValue();
                System.out.println("key: "+key+"    "+"value: "+value);
                if ("name".equals(key)){
                    Class<?> aClass = Class.forName(value);
                    Person person = (Person) aClass.newInstance();
                    person.show();
                }
            }
        }
    }

}
