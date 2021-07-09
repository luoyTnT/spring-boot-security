package com.example.security.service;

import com.example.security.query.LoginQuery;
import com.example.security.vo.UserLoginSuccessVo;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    UserLoginSuccessVo login(LoginQuery loginQuery);

    void logout(HttpServletRequest request);
}
