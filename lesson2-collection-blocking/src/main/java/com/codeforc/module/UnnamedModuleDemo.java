package com.codeforc.module;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: unnamed module foo
 * @Author: Ifan
 * date: 2021-02-18
 **/

public class UnnamedModuleDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    }
}
