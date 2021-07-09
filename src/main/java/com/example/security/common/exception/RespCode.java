package com.example.security.common.exception;

/**
 * 错误类型
 */
public interface RespCode {
    /**
     * 返回code
     */
    Integer getCode();

    /**
     * 返回的message
     */
    String getMsg();
}
