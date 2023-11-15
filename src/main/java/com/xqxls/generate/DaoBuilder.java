package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 构建Dao
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class DaoBuilder {


    /***
     * 构建Dao
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        if(Objects.nonNull(TemplateBuilder.PACKAGE_MAPPER)){
            //生成Dao层文件
            BuilderFactory.builder(modelMap,
                    "/template/dao",
                    "Mapper.java",
                    TemplateBuilder.PACKAGE_MAPPER,
                    "Mapper.java");
        }
    }

}
