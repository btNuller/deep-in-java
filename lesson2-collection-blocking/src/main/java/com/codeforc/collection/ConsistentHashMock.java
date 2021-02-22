package com.codeforc.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一致性hash算法:  github实现 https://github.com/Jaskey/ConsistentHash  /  https://github.com/clohfink/RendezvousHash
 * 主要解决问题为节点出现损坏时，对应的损坏节点请求失败和节点访问不均的情况
 *
 * 一个hash环, 模拟节点数为1024个, 实际可用的节点有8个(比如线上实际的ip服务节点), 1024个模拟节点跟8个ip节点有均匀的映射关系
 */
public class ConsistentHashMock {

    public static final Integer REAL_NODE_VALUES = 8;

    public static final Integer VIRTUAL_NODE_VALUES = 1024;

    public static Map<Integer, String> realNodeMap = new HashMap<>();

    public static TreeMap<Integer, String> virtualNodeMap = new TreeMap<>();

    static {
        for (int i = 0; i <= REAL_NODE_VALUES; i++){
            realNodeMap.put(i, "node" + i);
        }

        // 每个虚拟节点跟其取模的余数的 nodeMap 中的key相对应;
        // 下面删除虚拟节点的时候, 就可以根据取模规则来删除 TreeMap中的节点了;
        for (int i = 0; i <= VIRTUAL_NODE_VALUES; i++) {
            virtualNodeMap.put(i, realNodeMap.get(i % REAL_NODE_VALUES));
        }
    }

    public static String getRealServerNode(String value) {
        //1.根据传递过来的字符串得到对应的hash值
        Integer vnode = value.hashCode() % 1024;
        //2.找到对应节点最近的key的节点值
        String realNode = virtualNodeMap.ceilingEntry(vnode).getValue();
        return realNode;
    }

    public static void dropMalfunctionVirtualNode(String nodeName) {
        int nodek = -1;
        // 1. 遍历 nodeMap 找到故障节点 nodeName对应的key;
        for (Map.Entry<Integer, String> entry : realNodeMap.entrySet()) {
            if (nodeName.equalsIgnoreCase(entry.getValue())) {
                nodek = entry.getKey();
                break;
            }
        }
        if (nodek == -1) {
            System.err.println(nodeName + "在真实资源节点中无法找到, 放弃删除虚拟节点!");
            return;
        }

        // 2. 根据故障节点的 key, 对应删除所有 chMap中的虚拟节点
        Iterator<Map.Entry<Integer, String>> iter = virtualNodeMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, String> entry = iter.next();
            int key = entry.getKey();
            String value = entry.getValue();
            if (key % REAL_NODE_VALUES == nodek) {
                System.out.println("删除节点虚拟节点: [" + key + " = " + value + "]");
                iter.remove();
            }
        }
    }

    public static void main(String[] args) {
        // 1. 一个字符串请求(比如请求字符串存储到8个节点中的某个实际节点);
        String requestValue = "hello";
        // 2. 打印虚拟节点和真实节点的对应关系;
        System.out.println(virtualNodeMap);
        // 3. 核心: 传入请求信息, 返回实际调用的节点信息
        System.out.println(getRealServerNode(requestValue));
        // 4. 删除某个虚拟节点后
        System.out.println("==========删除 node_2 之后: ================");
        dropMalfunctionVirtualNode("node2");
        System.out.println("===============删除之后的虚拟节点map: ===========");
        System.out.println(virtualNodeMap);
        System.out.println("==============删除之后, 获取节点的真正node节点对应者: ");
        System.out.println(getRealServerNode(requestValue));
    }
}
