package com.zxd.admin.dto.admin.user;

import lombok.Data;

@Data
public class UpdateUserCommand extends AddUserCommand{
    private Long userId;
}
