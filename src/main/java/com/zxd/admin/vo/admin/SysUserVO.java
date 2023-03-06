package com.zxd.admin.vo.admin;

import cn.hutool.core.bean.BeanUtil;
import com.zxd.admin.entity.SysUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "SysUserVO", description = "系统用户列表")
public class SysUserVO {
    public SysUserVO(SysUser entity) {
        if(entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别 0=保密 1=女 2=男
     */
    private Integer gender;

    /**
     * 邮件
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 0=禁用 1=开启
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序值
     */
    private Integer orderNum;

    private Date createAt;

    private Date updateAt;
}
