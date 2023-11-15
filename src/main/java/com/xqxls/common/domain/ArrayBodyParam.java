package com.xqxls.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@ApiModel(value = "集合参数统一封装", description = "与前端约定,接口仅需要集合类型参数时,使用{'rows':[]}的格式传参")
public class ArrayBodyParam<T> {

    @ApiModelProperty(value = "集合参数")
    private List<T> rows;


    public ArrayBodyParam(List<T> rows) {
        this.rows = rows;
    }
}
