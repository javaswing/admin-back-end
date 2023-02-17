package com.zxd.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxd.admin.core.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限 & 菜单
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class SysMenu extends BaseEntity<SysMenu> {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父级ID
     */
    private Integer parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 0=目录 1=菜单 2=权限
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序值
     */
    private Integer orderNum;

    /**
     * 权限字符
     */
    private String perms;

    /**
     * 页面路径
     */
    private String viewPath;

    /**
     * 0=隐藏 1=显示
     */
    private Integer isShow;

}