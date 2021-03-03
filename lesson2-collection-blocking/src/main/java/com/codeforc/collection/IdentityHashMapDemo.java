package com.codeforc.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

    public static void main(String[] args) {
        Map<String, Object> map = new IdentityHashMap<>();
        map.put("A", 1);
        map.put(new String("A"), 1);
        System.out.println(map.size());
        //HashMap是key的hashcode和equals来实现的
        String test = "dsad";

        //如果类equals覆盖了，那么hashCode()是否需要覆盖
        //答案：不强制但是建议实现
        //如果类覆盖了hashCode


    }
}
