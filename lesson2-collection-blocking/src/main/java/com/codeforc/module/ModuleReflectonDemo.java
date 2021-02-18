package com.codeforc.module;

import java.lang.module.ModuleDescriptor;
import java.util.logging.Logger;

/**
 * @Description: 模块化反射demo
 * @Author: Ifan
 * date: 2021-02-18
 **/
public class ModuleReflectonDemo {

    public static void main(String[] args) {
        Class<Logger> loggerClass = Logger.class;
        Module module = loggerClass.getModule();
        String moduleName = module.getName();
        System.out.printf("Class %s 存在于模块 ：%s 之中\n", loggerClass.getName(), moduleName);
        ModuleDescriptor moduleDescriptor = module.getDescriptor();
        moduleDescriptor.requires().stream().forEach(requires -> {
            System.out.printf("requires 修饰符定义： %s , module名称： %s", requires.modifiers(), requires.name());
        });
    }
}
