package com.example.security.controller;

import com.example.security.common.utils.ApiResponse;
import com.example.security.query.LoginQuery;
import com.example.security.service.AuthService;
import com.example.security.vo.UserLoginSuccessVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 权限认证 登录,退出
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    /**
     * 登录
     *
     * @param loginQuery 登录信息
     * @return UserLoginSuccessVo
     */
    @PostMapping("/login")
    public ApiResponse<UserLoginSuccessVo> login(@RequestBody @Valid LoginQuery loginQuery) {
        return ApiResponse.success(this.service.login(loginQuery));
    }
}
