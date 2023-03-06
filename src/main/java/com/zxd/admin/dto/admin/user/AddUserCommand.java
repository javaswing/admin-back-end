package com.zxd.admin.dto.admin.user;

import lombok.Data;

@Data
public class AddUserCommand {

    private String account;

    private String username;

    private String nickName;

    private String avatar;

    private Integer gender;

    private String phone;

    private String email;

    private Integer status;

    private String remark;

}
