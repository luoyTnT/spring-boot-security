package com.example.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.entity.Permission;
import com.example.security.entity.Role;
import com.example.security.mapper.PermissionMapper;
import com.example.security.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<Permission> getPermissionByUserId(List<Role> roles) {
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        return this.baseMapper.selectPermissionByRoleIds(roleIds);
    }
}
