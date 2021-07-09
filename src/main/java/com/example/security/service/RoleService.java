package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
public interface RoleService extends IService<Role> {
    List<Role> getRoleListByUsername(String username);

    List<Role> getRoleListByUserId(Long userId);
}
