##  一入Java深似海

#####  项目提供的相关环境
京东1号

114.67.127.19

root

S65wUvY66qESDNib

--------------
京东2号

114.67.127.146

root

S65wUvY66qESDNib

###  1. 面向对象

######  通用设计——可访问性

- public：开放的API使用场景
  - java.lang.string

- （默认）仅在当前package下可访问，属于私有API，修饰成员，不能修饰class
  - java.io.FileStream
- protected：可继承的，修饰成员，不能修饰class
- private：私有的，修饰成员，不能修饰class

######  抽象类设计

  常见场景：

- 接口通用型实现
  - AbstractMap、Spring*Template
- 状态/状态继承
  - ArrayList
- 工具类
  - StringsUtils

常见模式：

- 介于类和接口的一种抽象（JDK8+ 可大部分由接口替代）
- 一般以"Abstract" 或 "Base"为前缀
  - java.util.AbstractCollection
  - javax.sql.rowset.BaseRowSet

######  接口设计

  常见场景：

-   需要抽象或隐藏具体的实现细节，例如上下游系统的通讯契约 （API、RPC）
-   常量定义

######  函数式编程

Since JDK8

@FunctionalInterface



###  2. 模块化编程

[^segmentfault]: 模块化编程更加聚焦功能，依赖或者暴露更为明确，对开发者的要求更高

#####  Java模块化基础及核心概念

######  模块路径（Module Path）

模块路径可能是单个artifact，或者是多个artifacts的目录，存在于宿主机器上。

  类路径（Class Path）的脆弱性

- 通过artifacts 的 Class Path 区分类型

- 无法区分artifacts

- 无法提前通知artifacts缺少

- 允许不同的artifacts定义在相同的packages定义类型

######  模块解析(Resolution)



###### 可读性（Readability）

如上图所示，模块com.foo.app依赖模块com.foo.bar和java.sql，说明java.sql对com.foo.app是可读的。同时，java.sql依赖java.xml和java.logging模块，然而这并不意味java.xml或java.logging对com.foo.app可读。简言之，可读性无法在跨层模块之间生效。

#####  

#####  Java模块化迁移

###### 迁移分析

需要明确应用实现依赖的JDK模块

需要明确二方或者三方jar所依赖的JDK模块

需要微服务化应用

凡是定义module-info.java (module-info.class) 属于命名模块（Java9 + 模块化 artifact）

Java9之前的artifact属于非命名模块

​    自动化模块

​		如果在 **MANIFEST.MF **定义了 **Automatic-Module-Name** 属性，那么采用该属性值作模块名称

​        否则，使用jar文件的名称（如果存在“-”的话，将其替换为“.”）



#####  总结

Java模块化对工程整体提升不大，但是对开发人员要求较高，另外Gradle、Maven可以通过严谨的引入方式避免Java模块化能解决的问题，起到相同的效果，目前Java模块化的应用并不广，但确是一种设计方向。

### 3.集合框架

##### 集合框架总览

> https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

集合框架是一个用于展示和操作集合的统一架构，其实现细节能够让集合独立操作。

## Introduction

The Java platform includes a *collections framework*. A *collection* is an object that represents a group of objects (such as the classic [Vector](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html) class). A collections framework is a unified architecture for representing and manipulating collections, enabling collections to be manipulated independently of implementation details.

The primary advantages of a collections framework are that it:

- **Reduces programming effort** by providing data structures and algorithms so you don't have to write them yourself.
- **Increases performance** by providing high-performance implementations of data structures and algorithms. Because the various implementations of each interface are interchangeable, programs can be tuned by switching implementations.
- **Provides interoperability between unrelated APIs** by establishing a common language to pass collections back and forth.
- **Reduces the effort required to learn APIs** by requiring you to learn multiple ad hoc collection APIs.
- **Reduces the effort required to design and implement APIs** by not requiring you to produce ad hoc collections APIs.
- **Fosters software reuse** by providing a standard interface for collections and algorithms with which to manipulate them.

###### 主要优势：

1. 提供数据结构和算法以减少程序员的开发工作
2. 通过数据结构和算法以提升程序性能
3. 提供无关API之间的互用性
4. 减少学习API的负担
5. 减少设计与实现API的负担
6. 促进软件重用

###### 基本组成：

1. Collection interfaces（集合接口）
2. Infrastructure（基础设施）
3. General-purpose implementations（通用实现）
4. Abstract implementations（抽象实现）
5. Legacy implementations（遗留实现）
6. Convenience implementations（便利实现）
7. Wrapper implementations（包装实现）
8. Special-purpose implementations（特殊实现）
9. Array Utilities（数组工具类）
10. Algorithms（算法）
11. Concurrent implementations（并发实现）

##### 集合框架内建实现

| 接口  | 哈希表  | 可变数组   | 平衡树  | 链表       | 哈希表+链表   |
| ----- | ------- | ---------- | ------- | ---------- | ------------- |
| Set   | HashSet |            | TreeSet |            | LinkedhashSet |
| List  |         | ArrayList  |         | LinkedList |               |
| Deque |         | ArrayQueue |         | LinkedList |               |
| Map   | HashMap |            | TreeMap |            | LinkedHashMap |



###### 并发实现

java.util.concurrent.LinkedBlockingQueue

java.util.concurrent.ArrayBlockingQueue

java.util.concurrent.PriorityBlockingQueue

java.util.concurrent.DelayQueue

java.util.concurrent.LinkedBlockingDeque

java.util.concurrent.CopyOnWriteArrayList

java.util.concurrent.LinkedTransferQueue

java.util.concurrent.CopyOnWriteArraySet

java.util.concurrent.ConcurrentSkipListSet





##### 常见问题

Q：如果类覆盖了Object的equals方法，那么hashCode方法需不需要覆盖？

A：不强制覆盖，但是建议实现，注意不要将hashCode()作为equals方法的实现，可参考Objects.hash()以及Arrays.hashCode(Object[]), hashCode()是一个计算较重的实现， equals通常是做对象属性的比较



Q：如果类覆盖了Object的hashCode()，那么equals(Object) 方法，方法需不需要覆盖？

A：必须实现hashCode()是用于hash计算的，比如HashMap，由于不同对象的hashCode()方法可能返回相同的数据，原因一：int数据范围是 - 2 ^ 31  ----  2 ^ 31 - 1

##### 总结