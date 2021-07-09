package com.example.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectPermissionByRoleIds(@Param("roleIds") List<Long> roleIds);
}
