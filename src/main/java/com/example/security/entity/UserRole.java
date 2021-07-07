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
 * 用户角色关系表
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sec_user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 角色主键
     */
    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
