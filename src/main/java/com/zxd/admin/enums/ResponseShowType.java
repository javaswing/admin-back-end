package com.zxd.admin.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseShowType {

    SILENT(0, "无提示"),
    WARN_MESSAGE(1, "警告信息"),
    ERROR_MESSAGE(2, "错误信息"),
    NOTIFICATION(3, "右侧注意提醒"),
    REDIRECT(9, "重定向");


    @JsonValue
    private final Integer code;
    private final String desc;

}
