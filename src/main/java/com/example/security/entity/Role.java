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
 * 角色表
 * </p>
 *
 * @author tanhaowen
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sec_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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
