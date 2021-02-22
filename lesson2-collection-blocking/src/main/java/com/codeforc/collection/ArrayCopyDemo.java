package com.codeforc.collection;

import java.util.List;

public class ArrayCopyDemo {

    public static void main(String[] args) {
        String[] strings = new String[]{"Hello", "World"};
        List<String> stringList = List.of();
        arrayCopy(strings, strings);
    }

    public static void arrayCopy(Object[] origin, Object[] targets) {
    }
}
