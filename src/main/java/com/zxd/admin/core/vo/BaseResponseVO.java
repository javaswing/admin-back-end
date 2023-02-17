package com.zxd.admin.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.zxd.admin.enums.StatusCodeEnum.SUCCESS;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BaseResponseVO", description = "通用前端交互信息结构")
public class BaseResponseVO<T> {

    @ApiModelProperty(value = "状态码", example = "200, 401")
    private int code;

    @ApiModelProperty(value = "提示信息")
    private String message;

    @ApiModelProperty(value = "数据")
    private T data;

    public static <T> BaseResponseVO<T> ok(T data) {
        return genBaseResponse(SUCCESS.getCode(), SUCCESS.getDesc(), data);
    }

    public static <T> BaseResponseVO ok() {
        return genBaseResponse(SUCCESS.getCode(), SUCCESS.getDesc(), null);
    }

    public static <T> BaseResponseVO ok(String msg) {
        return genBaseResponse(SUCCESS.getCode(), msg, null);
    }

    public static <T> BaseResponseVO fail(int code, T data, String message) {
        return genBaseResponse(code, message, data);
    }

    public static <T> BaseResponseVO fail(int code) {
        return genBaseResponse(code, null, null);
    }


    private static <T> BaseResponseVO<T> genBaseResponse(Integer code, String message, T data) {
        return BaseResponseVO.<T>builder()
                .code(code)
                .message(message)
                .data(data).build();
    }
}

