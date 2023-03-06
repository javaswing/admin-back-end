package com.zxd.admin.core.vo;

import com.zxd.admin.enums.ResponseShowType;
import com.zxd.admin.exception.ApiException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BaseResponseVO", description = "通用前端交互信息结构")
public class BaseResponseVO<T> {

    @ApiModelProperty(value = "执行结果", example = "true、 false")
    private boolean success;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "错误状态码", example = "401")
    private int errorCode;

    @ApiModelProperty(value = "执行错误提示信息")
    private String errorMessage;

    @ApiModelProperty(value = "弹窗提示类型")
    private ResponseShowType showType;


    public static <T> BaseResponseVO<T> ok(T data) {
        return BaseResponseVO.<T>builder()
                .success(true)
                .data(data)
                .showType(ResponseShowType.SILENT)
                .build();
    }

    public static <T> BaseResponseVO<T> ok(T data, ResponseShowType type) {
        return BaseResponseVO.<T>builder()
                .success(true)
                .data(data)
                .showType(type)
                .build();
    }

    public static <T> BaseResponseVO ok() {
        return BaseResponseVO.<T>builder()
                .success(true)
                .showType(ResponseShowType.SILENT)
                .build();
    }

    public static <T> BaseResponseVO fail(int errorCode, String errorMsg) {
        return genBaseResponse(null, false, errorCode, errorMsg, ResponseShowType.ERROR_MESSAGE);
    }
    public static <T> BaseResponseVO fail(int errorCode) {
        return genBaseResponse(null, false, errorCode, null, ResponseShowType.ERROR_MESSAGE);
    }

    public static <T> BaseResponseVO fail(int errorCode, String errorMsg, ResponseShowType showType) {
        return genBaseResponse(null, false, errorCode, errorMsg, showType);
    }

    public static <T> BaseResponseVO fail(ApiException exception) {
        return BaseResponseVO.<T>builder()
                .errorCode(exception.getErrorCode().code())
                .errorMessage(exception.getMessage())
                .success(false)
                .showType(ResponseShowType.ERROR_MESSAGE)
                .build();
    }


    private static <T> BaseResponseVO<T> genBaseResponse(T data, boolean success, Integer errorCode, String errorMessage, ResponseShowType showType) {
        return BaseResponseVO.<T>builder()
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .success(success)
                .showType(showType)
                .data(data).build();
    }
}

