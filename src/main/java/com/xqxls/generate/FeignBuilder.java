package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 构建Feign
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class FeignBuilder {


    /***
     * 构建Feign
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        if(Objects.nonNull(TemplateBuilder.PACKAGE_FEIGN)){
            //生成Dao层文件
            BuilderFactory.builder(modelMap,
                    "/template/feign",
                    "Feign.java",
                    TemplateBuilder.PACKAGE_FEIGN,
                    "Feign.java");
        }
    }

}
