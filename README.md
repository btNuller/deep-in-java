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

####  1. 面向对象

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



####  2. 模块化编程

[^segmentfault]: 模块化编程更加聚焦功能，依赖或者暴露更为明确，对开发者的要求更高

#####  Java模块化基础

######  模块路径（Module Path）

模块路径可能是单个artifact，或者是多个artifacts的目录，存在于宿主机器上。

  类路径（Class Path）的脆弱性

- 通过artifacts 的 Class Path 区分类型

- 无法区分artifacts

- 无法提前通知artifacts缺少

- 允许不同的artifacts定义在相同的packages定义类型

######  模块解析(Resolution)

![image-20210218161636651](http://www.codeforc.com:9000/public/deepinjava/1-1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20210218%2F%2Fs3%2Faws4_request&X-Amz-Date=20210218T101144Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=e36e57a00a3a7c7788f566957d4628841ed78f4c7ae15fdf28a342e18d060f4e)

###### 可读性（Readability）

如上图所示，模块com.foo.app依赖模块com.foo.bar和java.sql，说明java.sql对com.foo.app是可读的。同时，java.sql依赖java.xml和java.logging模块，然而这并不意味java.xml或java.logging对com.foo.app可读。简言之，可读性无法在跨层模块之间生效。

#####  

#####  Java模块化迁移

###### 迁移分析

需要明确应用实现依赖的JDK模块

需要明确二方或者三方jar所依赖的JDK模块

需要微服务化应用

#####  Java模块化反射

#####  总结

