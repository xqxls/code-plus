package com.xqxls.util;

import com.xqxls.common.domain.UserDto;

public class SecurityUtil {

    /**
     * 获取访问的用户信息
     *
     * @return
     */
    public static UserDto getUserDTO() {
        return UserUtil.getCurrentUser();
    }


}
