package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.Permission;
import com.example.security.entity.Role;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
public interface PermissionService extends IService<Permission> {
    List<Permission> getPermissionByUserId(List<Role> roles);
}
