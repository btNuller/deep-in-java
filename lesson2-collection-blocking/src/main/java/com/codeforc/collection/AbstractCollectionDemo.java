package com.codeforc.collection;

import java.util.*;

/**
 * AbstractCollection
 */
public class AbstractCollectionDemo {

    public static void main(String[] args) {
//        abstractList();
        List<String> objects = new ArrayList<>();
        objects.add("test1");
        objects.add("test2");
        objects.add("test3");
        objects.add("test4");
        randomAccess(objects);

        Integer[] intarray = of(1,2,3,4,5,6, 188);

        Integer[] intArrayCopy = Arrays.copyOf(intarray, intarray.length);
        intArrayCopy[0] = 999;

        System.out.println(Arrays.toString(intarray));
        System.out.println();
        System.out.println(Arrays.toString(intArrayCopy));
    }

    private static void abstractList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Java 1.4 断言 assertion
        assert numbers instanceof AbstractList;
        // 返回了 Arrays.ArrayList 不允许写操作但是允许下标数据交换
        // unsupport method
//        numbers.add(0);
        numbers.set(4, 0);

        numbers.forEach(System.out::println);
    }

    public static void randomAccess(Collection<String> collection) {
        collection.forEach(System.out::println);

        System.out.println("update");
        collection.add("time for you");
        collection.remove("test1");
        collection.forEach(System.out::println);
    }

    public static Integer[] of(Integer... values) {
        return values;
    }
}
