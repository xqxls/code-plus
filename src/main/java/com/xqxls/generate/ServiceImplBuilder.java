package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 构建serviceimpl
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class ServiceImplBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        if(Objects.nonNull(TemplateBuilder.PACKAGE_SERVICE_INTERFACE_IMPL)){
            //生成ServiceImpl层文件
            BuilderFactory.builder(modelMap,
                    "/template/service/impl",
                    "ServiceImpl.java",
                    TemplateBuilder.PACKAGE_SERVICE_INTERFACE_IMPL,
                    "ServiceImpl.java");
        }
    }

}
