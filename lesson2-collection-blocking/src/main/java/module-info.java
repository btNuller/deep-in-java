module lesson2.collection.blocking {

    requires java.base;  //默认依赖
    requires java.compiler; //exports 控制可访问的 API 包
    requires java.sql; //传递依赖 requires
    
}