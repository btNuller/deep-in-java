package com.codeforc.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * 遗留实现
 */
public class LegacyCollectionDemo {

    public static void main(String[] args) {

        // 1几乎所有实现是线程安全
        // 对比 ArrayList   Vector也是实现了List 基于 AbstractList 实现
        Vector<String> vector = new Vector<>();
        vector.add("test");
        List<String> list = new ArrayList<>();

        //如果 Vector 在方法内部使用的话，
        // synchronized修饰后的方法基本上没有太多的线程同步的性能消耗


    }
}
