package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
public interface UserService extends IService<User> {
    User getUserByUsername(String username);
}
