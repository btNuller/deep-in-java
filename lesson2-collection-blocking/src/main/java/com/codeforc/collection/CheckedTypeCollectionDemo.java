package com.codeforc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类型检查Collections.checkedxxx
 */
public class CheckedTypeCollectionDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

//        list.add("1");
        List otherList = list;
        System.out.println(otherList == list);
//        otherList.add("a");

        //
        List<Integer> checkValues = Collections.checkedList(list, Integer.class);

        list.forEach(System.out::println);
        System.out.println(checkValues == list);

        System.out.println(checkValues == otherList);
    }

}
