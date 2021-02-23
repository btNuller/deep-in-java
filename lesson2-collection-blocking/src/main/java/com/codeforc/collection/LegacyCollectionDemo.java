package com.codeforc.collection;

import java.util.*;

/**
 * 遗留实现
 */
public class LegacyCollectionDemo {

    public static void main(String[] args) {
        vectorVsList();
        hashtableVsHashMap();
        enumerationVsEnum();
    }

    private static void enumerationVsEnum() {
        //Enumeration 上要用于迭代早起实现，由于 java.util.Iterator 从Java1.2 引入
        String value = "1,2,3";
        value.split("");
        StringTokenizer tokenizer = new StringTokenizer(value, ",");
        Enumeration enumeration = tokenizer;
        while( enumeration.hasMoreElements() ) { // Iterator.hashNext()
            String element = (String)enumeration.nextElement();
            System.out.println(element);
        }

        // Iterable 从 Java 5 引入 用于 for-each提升
    }

    private static void hashtableVsHashMap() {
        // Hashtable 和 HashMap都实现了Map接口
        // Hashtable实现 Dictionary和Map接口
        // Hashtable线程安全 、 HashMap线程不安全
        // Hashtable是不允许null value 的
        Hashtable<String, Object> hashtable = new Hashtable<>();

//        hashtable.put("a", null);

        // HashMap 实现 Map 接口
        // 线程不安全（写操作）
        // HashMap 允许 null value
        // ConcurrentHashMap不允许 null value的
        // 如果value为空 ConcurrentHashMap在查询数据时，会产生歧义：
        // 到底是值为null 还是 线程不可见
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("a", null);


    }

    private static void vectorVsStack() {
        // Stack 是 FILO
        Stack<String> stack = new Stack<>();
    }

    private static void vectorVsList() {
        //Vector数组实现对比ArrayList实现了 List
        //Vector所以的操作都是线程安全的，使用关键词 synchronized修饰
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();
        vector.add("a");
        list.add("a");
        //如果 Vector 在方法内部使用的话，synchronized修饰后的方法基本上没有太多的线程同步的性能消耗


    }
}
