package com.zxd.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCodeEnum {

    SUCCESS(200, "操作成功"),
    NO_LOGIN(401, "未登录"),
    VALID_ERROR(-1, "参数验证失败"),
    EXPIRED_JWT(11001, "凭证过期");

    private final Integer code;

    private final String desc;
}
