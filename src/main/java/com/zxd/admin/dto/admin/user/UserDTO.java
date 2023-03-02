package com.zxd.admin.dto.admin.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private Long userId;

    private String account;

    private String username;

    private String nickName;

    private String avatar;

    private Integer gender;

    private String mobile;

    private String email;

    private Integer status;

    private String remark;

    private Date createAt;

    private Date updateAt;
}
