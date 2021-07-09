package com.example.security.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginQuery {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码标识不能为空")
    private String verify;

    @NotBlank(message = "验证码不能为空")
    private String code;

    private Boolean rememberMe = false;
}
