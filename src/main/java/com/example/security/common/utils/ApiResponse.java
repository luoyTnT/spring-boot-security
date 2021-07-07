package com.example.security.common.utils;

import com.example.security.common.exception.RespCode;
import com.example.security.common.exception.SystemRespCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
@Data
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code = SystemRespCode.SUCCESS.getCode();
    private String msg = SystemRespCode.SUCCESS.getMsg();
    private T data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(T data) {
        super();
        this.data = data;
    }

    public ApiResponse(RespCode respCode) {
        super();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public ApiResponse(RespCode respCode, T data) {
        super();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(SystemRespCode.SUCCESS);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SystemRespCode.SUCCESS, data);
    }

    public static <T> ApiResponse<T> fail() {
        return new ApiResponse<>(SystemRespCode.FAILED);
    }

    public static <T> ApiResponse<T> status(boolean flag) {
        return flag ? success() : fail();
    }
}
