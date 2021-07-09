package com.example.security.config;

import com.example.security.entity.Permission;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.service.PermissionService;
import com.example.security.service.RoleService;
import com.example.security.service.UserService;
import com.example.security.vo.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义UserDetails查询
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        List<Role> roles = roleService.getRoleListByUserId(user.getId());
        List<Permission> permissions = permissionService.getPermissionByUserId(roles);
        return UserPrincipal.create(user, roles, permissions);
    }
}
