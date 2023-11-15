package com.xqxls.generate;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 构建Controller
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class ControllerBuilder {

    /***
     * 构建Controller
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        if(Objects.nonNull(TemplateBuilder.PACKAGE_CONTROLLER)){
            //生成Controller层文件
            BuilderFactory.builder(modelMap,
                    "/template/controller",
                    "Controller.java",
                    TemplateBuilder.PACKAGE_CONTROLLER,
                    "Controller.java");
        }
    }

}
