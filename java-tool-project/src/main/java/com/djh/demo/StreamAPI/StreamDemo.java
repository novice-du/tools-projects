package com.djh.demo.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream特性：
 * 1.不是数据结构，没有内部存储
 * 2.不支持索引访问
 * 3.延迟计算
 * 4.支持并行
 * 5.很容易生成数组或集合(List,Set)
 * 6.支持过滤，查找，转换，汇总，聚合等操作
 *
 *
 * Stream的创建 5种
 */
public class StreamDemo {

    public static void main(String[] args) {
//        gen1();
//        gen2();
//        gen3();
//        gen4();
//        gen5();

        //中间操作: 如果调用方法之后返回的是Stream对象，就意味着是一个中间操作
        //如果不执行终止操作，那么中间操作就永远不会执行
        //输出偶数
        Arrays.asList(1,2,3,4,5).stream().filter((x)->x%2==0).forEach(System.out::println);
        //求所有偶数和   mapToInt()：转成IntStream,IntStream中有sum求和方法
        int sum = Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println("sum: "+sum);
        //求集合中最大值
        Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5).stream().max((a, b) -> a - b);
        System.out.println("max: "+max.get());
        //求集合中最小值
        System.out.println("min: "+Arrays.asList(1, 2, 3, 4, 5).stream().min((a,b)->a-b).get());
        //取集合中第一个元素
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(x->x%2==0).findFirst());
        //其他操作
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5).stream().filter(
            (i)->{
                System.out.println("中间操作");
                return i%2==0;                 //当符合条件时，代码终止，所以此段逻辑中输出语句会执行两次
            }
        );
        System.out.println(stream.findFirst().get()); //若只输出stream,则因没有执行终止操作，导致"中间操作"这句话不会输出。
        //不使用max，min进行排序找最大最小值
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5).stream().sorted().findFirst();
        System.out.println("排序最小值： "+first.get());
        Optional<Integer> first1 = Arrays.asList(1, 2, 3, 4, 5).stream().sorted((a, b) -> b - a).findFirst();
        System.out.println("排序最大值： "+first1.get());
        //将集合中的元素过滤后返回一个集合对象
        List<Integer> collect = Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //去重
        Arrays.asList(1, 1, 2, 3, 3, 4, 5).stream().distinct().forEach(System.out::println);
        //打印20-30这样的集合数据
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);
        //截取字符串，相加求和
        String str = "11,22,33,44,55";
        System.out.println("相加求和"+Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println("相加求和"+Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println("相加求和"+Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println("相加求和"+Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());
        //创建一组自定义对象
        String str2 = "zhangsan,lisi,王五,赵六";
        Stream.of(str2.split(",")).map((x)->new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        //将集合中所有值都打印出来，并求和
        System.out.println("打印所有元素，并求和"+Arrays.asList(1, 1, 2, 3, 3, 4, 5).stream().peek(System.out::println).mapToInt(Integer::intValue).sum());
        //判断所有元素是否都符合逻辑   返回true或false
        System.out.println("allMatch: "+Arrays.asList(1, 1, 2, 3, 3, 4, 5).stream().allMatch(x -> x % 2 == 0));
        System.out.println("allMatch: "+Arrays.asList(1, 1, 2, 3, 3, 4, 5).stream().allMatch(x -> x > 0));
    }

    //通过数组
    static void gen1(){
        String[] strings = {"张三","李四","王五","赵六"};
        Stream<String> stream = Stream.of(strings);
        stream.forEach(System.out::println);
    }
    //通过集合
    static void gen2(){
        List<String> list = Arrays.asList("张三","李四","王五","赵六");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }
    //通过Stream.generate  输出1-10  limit指定一下做大数，否则会一直输出
    static void gen3(){
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }
    //通过Stream.iterate  输出1-10
    static void gen4(){
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }
    //其他方式
    static void gen5(){
        String str = "abcde";
        IntStream chars = str.chars();
        chars.forEach(System.out::println);
    }

}
