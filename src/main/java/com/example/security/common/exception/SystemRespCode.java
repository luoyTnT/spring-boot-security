package com.example.security.common.exception;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum SystemRespCode implements RespCode {
    SUCCESS(0, "成功"),
    FAILED(-1, "失败");

    @JsonValue
    @Getter
    private final int code;
    /**
     * 错误类型描述信息
     */
    private final String msg;

    SystemRespCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
