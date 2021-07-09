package com.example.security.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JWT 响应返回
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginSuccessVo {
    /**
     * token 字段
     */
    private String token;
    /**
     * token类型
     */
    private String tokenType = "Bearer";
    /**
     * 用户信息
     */
    private UserPrincipal userInfo;
}
