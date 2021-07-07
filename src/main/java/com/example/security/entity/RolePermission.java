package com.example.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sec_role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键
     */
    @TableId(type = IdType.AUTO)
    private Long roleId;

    /**
     * 权限主键
     */
    private Long permissionId;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
