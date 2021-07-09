package com.example.security.service;

import com.example.security.query.LoginQuery;
import com.example.security.vo.UserLoginSuccessVo;
import com.example.security.vo.VerifyVO;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    VerifyVO createVerify();

    UserLoginSuccessVo login(LoginQuery loginQuery);

    void logout(HttpServletRequest request);
}
