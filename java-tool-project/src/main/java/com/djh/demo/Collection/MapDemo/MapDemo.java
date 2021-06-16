package com.djh.demo.Collection.MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Collection是单列集合
 *
 * Map（双列集合）：键必须是唯一的，键所对应的值也是唯一的
 * hashMap（底层是哈希表数据结构）：允许null值，允许null键；同步的
 * Properties：不常用
 * TreeMap(基于红黑树):
 * HashTable: 同步的，不允许使用null，其他和HashMap大致相同
 */
public class MapDemo {

    public static void main(String[] args) {
        hashMap();
    }
    public static void hashMap() {
        Map map = new HashMap();
        map.put("张三", "张小三");   //添加元素
        map.put(1, "李四");
        map.put(2, 2);
        map.put(1, "李四");
        map.put(1, "王五");
        map.put(null, "小明");   //Map中允许有空键
        map.get(2);    //get（）方法，通过键来获取值
        map.isEmpty();    //判断元素是否为空
        map.size();    //集合长度
        map.remove("2");       //根据Key删除对应的Value
        map.containsKey("1");   //判断指定的Key是否存在
        map.containsValue("李四");   //根据指定的Value是否存在
        map.keySet();    //Map中所有的key的集合   返回的是一个Set集合
        map.values();   //取出所有Value  返回的是一个Collection集合
        //map.clear();   //清除Map集合
        map.put(5, "王五");
        //map.put("小红",2);
        //System.out.println(map);

        firstMethod(map);
    }
        /**
         * Map集合的三种遍历方式
         */

        //1. 通过Map.Entry进行遍历   如果键值的类型都不是固定的，只能用Object接受，这样的话，只能通过toString
        //方法打印，不能分开通过.getKey和getValue打印
        //该方法是将map中的key和value一一对应的封装到Entry中，然后遍历entry对象即可从中得到指定的key和value
        public static void firstMethod(Map map){
           for (Object entry: map.entrySet()){
               System.out.println(entry.toString());
           }
        }

        //2. 调用map.keySet进行遍历
        //将map中的所有key值都取出来存放到了Set集合中
        public static void firstMethod2(Map map){
            for (Object key:map.keySet()) {
                String values = map.get(key).toString();
                System.out.println("键："+key+"========"+"值："+values);
            }
        }
        //3.迭代器遍历  比较常用
        //该方法是将map中的key和value一一对应的封装到Entry中，然后遍历entry对象即可从中得到指定的key和value
        public static void firstMethod3(Map map){
            Set<Entry> entrySet = map.entrySet();
            Iterator<Entry> iterator = entrySet.iterator();
            while (iterator.hasNext()){
                Entry next = iterator.next();
                if ("王五".equals(next.getValue()))    //next.getValue()要放在后边，因为如果next对象为空，那么将报空指针异常
                    next.setValue("小军");       //将值为“王五”的，都该成“小军”
                System.out.println("键："+next.getKey()+"========"+"值："+next.getValue());
            }
        }
}
