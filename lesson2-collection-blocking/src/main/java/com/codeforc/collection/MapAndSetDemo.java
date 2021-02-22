package com.codeforc.collection;

import java.util.*;

public class MapAndSetDemo {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        map.put("hashMap", "Hello,HashMap");
        set.add("Hello,hashSet");
        System.out.println(map);
        System.out.println(set);

        map = new TreeMap<>();
        set = new TreeSet();
        map.put("treeMap", "Hello,TreeMap");
        set.add("Hello,TreeSet");
        System.out.println(map);
        System.out.println(set);
    }
}
