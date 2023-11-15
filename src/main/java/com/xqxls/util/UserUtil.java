package com.xqxls.util;

import cn.hutool.json.JSONObject;
import com.nimbusds.jose.JWSObject;
import com.xqxls.common.domain.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * 获取登录用户的信息
 */
@Slf4j
public class UserUtil {
    public static UserDto getCurrentUser() {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String realToken = request.getHeader("user");
        if(realToken==null){
            return  new UserDto();
        }
        JWSObject jwsObject = null;  //签名已经通过校验,可以直接解析
        try {
            jwsObject = JWSObject.parse(realToken);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String userStr = jwsObject.getPayload().toString();
        log.info("====>用户信息:{}", userStr);
        JSONObject userJsonObject = new JSONObject(userStr);
        UserDto userDTO = new UserDto();
        userDTO.setUsername(userJsonObject.getStr("user_name"));
        userDTO.setId(userJsonObject.getLong("id"));
        userDTO.setTenementId(userJsonObject.getLong("tenementId"));
        return userDTO;
    }
}
