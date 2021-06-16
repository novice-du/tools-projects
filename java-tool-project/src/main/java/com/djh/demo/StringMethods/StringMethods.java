package com.djh.demo.StringMethods;

/**
 * String类的常用方法
 *
 * compareTo(String anotherString): 按字典顺序比较两个字符串。
 * concat(String str): 将指定的字符串连接到该字符串的末尾。
 * contains(CharSequence s): 当且仅当此字符串包含指定的char值序列时才返回true。
 * endsWith(String suffix): 测试此字符串是否以指定的后缀结尾。
 * equals(Object anObject): 将此字符串与指定对象进行比较。
 * hashCode(): 返回此字符串的哈希码。
 * indexOf(int ch): 返回指定字符第一次出现的字符串内的索引。
 * isEmpty(): 返回 true如果，且仅当 length()为 0 。
 * lastIndexOf(int ch): 返回指定字符的最后一次出现的字符串中的索引。
 *            (String str): 返回指定子字符串最后一次出现的字符串中的索引。
 *  length(): 返回此字符串的长度。
 *  replace(char oldChar, char newChar): 返回从替换所有出现的导致一个字符串 oldChar在此字符串 newChar 。
 *  split(String regex): 将此字符串分割为给定的 regular expression的匹配。
 *  startsWith(String prefix): 测试此字符串是否以指定的前缀开头。
 *  toCharArray(): 将此字符串转换为新的字符数组。
 *  trim(): 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格
 *  valueOf(double d): 返回 double参数的字符串 double形式。
 */
public class StringMethods {
    public static void main(String[] args) {
        method1();
    }
    public static void method1(){
        String st1 = "ab,cde,fcg";
        String st2 = "hijklmn";
        String st3 = "abc";
        char chr[] = {'1','2','3','4','5'};
        char chr2[] = {'6','7','8','9'};
        double doubles = 1.11;
        System.out.println("compareTo :  "+st2.compareTo(st1));
        System.out.println("concat :  "+st1.concat(st2));
        System.out.println("contains :  "+st1.contains(st3));
        System.out.println("indexOf :  "+st1.indexOf("c"));
        System.out.println("lastIndexOf :  "+st1.lastIndexOf("c"));
//        System.out.println("replace :  "+st1.replace(char chr,char chr2));
        System.out.println("split :  "+st1.split(","));
        System.out.println("toCharArray :  "+st2.toCharArray());
        System.out.println("valueOf :  "+String.valueOf(doubles));
    }
}
