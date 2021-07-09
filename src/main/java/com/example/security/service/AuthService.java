package com.example.security.service;

import com.example.security.query.LoginQuery;
import com.example.security.vo.UserLoginSuccessVo;

public interface AuthService {
    UserLoginSuccessVo login(LoginQuery loginQuery);
}
