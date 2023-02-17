package com.zxd.admin.dto;

import lombok.Data;

@Data
public class SystemUserQuery {
    private Long userId;

    private String userName;

    private String phoneNumber;
}
