package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 生成swagger
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class SwaggerBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        if(Objects.nonNull(TemplateBuilder.SWAGGERUI_PATH)){
            //swagger的文件名字
            modelMap.put("Table","swagger");

            //生成ServiceImpl层文件
            BuilderFactory.builder(modelMap,
                    "/template/swagger",
                    "swagger.json",
                    TemplateBuilder.SWAGGERUI_PATH,
                    ".json");
        }
    }
}
