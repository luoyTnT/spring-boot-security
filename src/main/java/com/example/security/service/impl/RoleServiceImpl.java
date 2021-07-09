package com.example.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.mapper.RoleMapper;
import com.example.security.service.RoleService;
import com.example.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final UserService userService;

    @Override
    public List<Role> getRoleListByUsername(String username) {
        User user = this.userService.getUserByUsername(username);
        return this.baseMapper.selectRoleListByUserId(user.getId());
    }

    @Override
    public List<Role> getRoleListByUserId(Long userId) {
        return this.baseMapper.selectRoleListByUserId(userId);
    }
}
