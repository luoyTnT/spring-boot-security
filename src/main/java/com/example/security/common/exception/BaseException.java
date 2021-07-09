package com.example.security.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    private Integer code;
    private String msg;
    private Object data;

    public BaseException(SystemRespCode status) {
        super(status.getMsg());
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public BaseException(SystemRespCode status, Object data) {
        this(status);
        this.data = data;
    }

    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(Integer code, String msg, Object data) {
        this(code, msg);
        this.data = data;
    }

}
