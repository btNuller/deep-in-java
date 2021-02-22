package com.codeforc.collection;

import java.util.HashSet;
import java.util.Set;

public class ListAndSetDemo {

    public static void main(String[] args) {

        //不具备排序功能，但由于编码问题和String的hashcode规则，可能是有序的 ——> 排序需用 SortedHashSet
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.forEach(System.out::println);

        set.clear();


        set.add("1");
        set.add("2");
        set.add("3");
        set.forEach(System.out::println);


    }
}
