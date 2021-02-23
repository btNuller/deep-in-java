package com.codeforc.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/**
 * AbstractCollection
 */
public class AbstractCollectionDemo {

    public static void main(String[] args) {
        abstractList();
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
}
