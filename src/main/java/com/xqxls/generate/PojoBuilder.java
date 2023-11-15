package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 构建pojo
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class PojoBuilder {


    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        if(Objects.nonNull(TemplateBuilder.PACKAGE_POJO)){
            //生成Pojo层文件
            BuilderFactory.builder(dataModel,
                    "/template/pojo",
                    "Pojo.java",
                    TemplateBuilder.PACKAGE_POJO,
                    ".java");
        }
    }

}
