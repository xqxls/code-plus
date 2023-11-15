package com.xqxls.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2023/11/13 9:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto {
    private Long id;
    private Long tenementId;
    private String username;
}
