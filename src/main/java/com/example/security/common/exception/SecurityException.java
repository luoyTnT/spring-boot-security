package com.example.security.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 全局异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SecurityException extends BaseException {
    public SecurityException(SystemRespCode status) {
        super(status);
    }

    public SecurityException(SystemRespCode status, Object data) {
        super(status, data);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
