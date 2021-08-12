package com.caleb.java.java8.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Date 2021/6/21 11:51
 * Consumer:消费性接口 ，有参无返回值。
 * Supplier:供给型接口, 无参有返回值。
 * Function:函数型接口，有参有返回值。
 * Predicate:断言型接口，有参有返回值，返回值boolean类型
 */
public class TestFunctional {
    public static void main(String[] args) {
        //匿名内部类
//        Consumer<Double> consumer=new Consumer<Double>() {
//            @Override
//            public void accept(Double d) {
//                System.out.println("吃饭聚餐花费:"+d);
//            }
//        };
       // Consumer<Double> consumer=d-> System.out.println("吃饭聚餐花费:"+d);

        happy(d-> System.out.println("吃饭聚餐花费:"+d), 1000);
        happy(d-> System.out.println("KTV花费:"+d), 2000);


//        Supplier<Integer> sup=new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return new Random().nextInt(100);
//            }
//        };
       // Supplier<Integer> sup=()->new Random().nextInt(100);

//        int[] nums = getNums(()->new Random().nextInt(500), 10);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

//        Function<String,String> fun=new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        };
//        Function<String,String> fun=s->s.toUpperCase();
//        String r=handleString(s->s.trim(), "    hello   ");
//        System.out.println(r);

//        Predicate<String> p=new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                if(s.startsWith("王")){
//                    return true;
//                }
//                return false;
//            }
//        };
       // Predicate<String> p=s->s.startsWith("张");
        ArrayList<String> list=new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("张树桐");
        list.add("张富康");
        ArrayList<String> list2=filter(s->s.startsWith("王"), list);
        System.out.println(list2);
    }
    // Consumer 消费型 happy 玩
    public static void happy(Consumer<Double> con,double m){
        con.accept(m);
    }
    //Supplier 供给型
    public static int[] getNums(Supplier<Integer> sup,int len){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=sup.get();
        }
        return arr;
    }
    //Function, 函数型
    public static String handleString(Function<String,String> fun,String str){
        return fun.apply(str);
    }
    //Predicate,断言型接口
    public static ArrayList<String> filter(Predicate<String> p, ArrayList<String> list){
        ArrayList<String> nameList=new ArrayList<>();
        for (String s : list) {
            if(p.test(s)){
                nameList.add(s);
            }
        }
        return nameList;
    }
}
