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
 * 用户表
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sec_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private Long birthday;

    /**
     * 性别，男-1，女-2
     */
    private Integer sex;

    /**
     * 状态，启用-1，禁用-0
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
