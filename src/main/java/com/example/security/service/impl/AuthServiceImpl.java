package com.example.security.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.example.security.common.exception.BaseException;
import com.example.security.common.exception.SecurityException;
import com.example.security.common.exception.SystemRespCode;
import com.example.security.entity.User;
import com.example.security.query.LoginQuery;
import com.example.security.service.AuthService;
import com.example.security.service.UserService;
import com.example.security.util.JwtUtil;
import com.example.security.util.RedisUtil;
import com.example.security.vo.UserLoginSuccessVo;
import com.example.security.vo.UserPrincipal;
import com.example.security.vo.VerifyVO;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RedisUtil redisUtil;
    private final JwtUtil jwtUtil;

    @Override
    public VerifyVO createVerify() {
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(100, 30, 4, 3);
        val uuid = UUID.randomUUID().toString();
        this.redisUtil.setGuidAndVerifyCode(uuid, circleCaptcha.getCode());
        return new VerifyVO(uuid, circleCaptcha.getImageBase64());
    }

    @Override
    public UserLoginSuccessVo login(LoginQuery loginQuery) {
        userCheck(loginQuery);

        verifyCheck(loginQuery.getVerify(), loginQuery.getCode());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginQuery.getUsername(), loginQuery.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = this.jwtUtil.createJWT(authentication, loginQuery.getRememberMe());

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        return UserLoginSuccessVo.builder()
                .token(jwt)
                .userInfo(principal)
                .build();
    }

    @Override
    public void logout(HttpServletRequest request) {
        try {
            // 设置JWT过期
            this.jwtUtil.invalidateJWT(request);
        } catch (SecurityException e) {
            throw new SecurityException(SystemRespCode.UNAUTHORIZED);
        }
    }

    private void userCheck(LoginQuery loginQuery) {
        User user = this.userService.getUserByUsername(loginQuery.getUsername());
        if (ObjectUtil.isEmpty(user)) {
            throw new BaseException(SystemRespCode.USERNAME_PASSWORD_ERROR);
        }
    }

    private void verifyCheck(String verify, String code) {
        String redisCode = this.redisUtil.getVerifyCodeByGuid(verify);
        if (!code.equals(redisCode)) {
            throw new BaseException(SystemRespCode.FAILED, "验证码不正确");
        }
    }

}
