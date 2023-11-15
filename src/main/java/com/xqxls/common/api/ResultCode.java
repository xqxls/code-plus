package com.xqxls.common.api;


/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2023/11/13 9:12
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    NOT_FINISHED(202, "请求未完成"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
