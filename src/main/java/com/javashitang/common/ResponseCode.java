package com.javashitang.common;

/**
 * @Author: lilimin
 * @Date: 2019/6/9 12:19
 */
public enum ResponseCode {

    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    ILLEGAL_ARGUMENT(2, "参数错误"),
    EMPTY_RESULT(3, "结果为空"),
    NEED_LOGIN(10, "需要登录");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
