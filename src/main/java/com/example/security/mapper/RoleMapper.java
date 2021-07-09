package com.example.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectRoleListByUserId(@Param("userId") Long userId);
}
