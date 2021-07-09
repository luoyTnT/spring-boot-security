package com.example.security.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.security.common.exception.BaseException;
import com.example.security.common.exception.SystemRespCode;
import com.example.security.entity.User;
import com.example.security.query.LoginQuery;
import com.example.security.service.AuthService;
import com.example.security.service.UserService;
import com.example.security.util.JwtUtil;
import com.example.security.vo.UserLoginSuccessVo;
import com.example.security.vo.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Override
    public UserLoginSuccessVo login(LoginQuery loginQuery) {
        userCheck(loginQuery);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginQuery.getUsername(), loginQuery.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.createJWT(authentication, loginQuery.getRememberMe());

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        return UserLoginSuccessVo.builder()
                .token(jwt)
                .userInfo(principal)
                .build();
    }

    private void userCheck(LoginQuery loginQuery) {
        User user = this.userService.getUserByUsername(loginQuery.getUsername());
        if (ObjectUtil.isEmpty(user)) {
            throw new BaseException(SystemRespCode.USERNAME_PASSWORD_ERROR);
        }
    }

}
