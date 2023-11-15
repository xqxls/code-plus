package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 构建service
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class ServiceBuilder {


    /***
     * 构建Service
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        if(Objects.nonNull(TemplateBuilder.PACKAGE_SERVICE_INTERFACE)){
            //生成Service层文件
            BuilderFactory.builder(modelMap,
                    "/template/service",
                    "Service.java",
                    TemplateBuilder.PACKAGE_SERVICE_INTERFACE,
                    "Service.java");
        }
    }

}
