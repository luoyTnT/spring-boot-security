package com.example.security.common.utils;

import com.example.security.common.exception.BaseException;
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
        return new ApiResponse<>(SystemRespCode.ERROR);
    }

    public static <T> ApiResponse<T> status(boolean flag) {
        return flag ? success() : fail();
    }

    /**
     * 构造一个有状态的API返回
     *
     * @param status 状态 {@link SystemRespCode}
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> ofStatus(SystemRespCode status) {
        return ofStatus(status, null);
    }

    /**
     * 构造一个有状态且带数据的API返回
     *
     * @param status 状态 {@link RespCode}
     * @param data   返回数据
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> ofStatus(RespCode status, T data) {
        return of(status.getCode(), status.getMsg(), data);
    }

    /**
     * 构造一个自定义的API返回
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> of(Integer code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

    /**
     * 构造一个异常的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }

}
