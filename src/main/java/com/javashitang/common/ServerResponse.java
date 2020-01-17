package com.javashitang.common;

/**
 * @Author: lilimin
 * @Date: 2019/6/9 12:18
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
/** 注解的作用是序列化json时，如果是null对象，key也会消失 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse implements Serializable {

    /** 状态值 **/
    private int status;
    /** 描述 **/
    private String msg;
    /** 数据 **/
    private Object data;

    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static ServerResponse success() {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc());
    }

    public static ServerResponse illegalArgument(String msg) {
        return new ServerResponse(ResponseCode.ILLEGAL_ARGUMENT.getCode(), msg);
    }
}
