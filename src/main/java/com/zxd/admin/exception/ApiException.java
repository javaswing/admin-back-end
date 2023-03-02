package com.zxd.admin.exception;

import cn.hutool.core.util.StrUtil;
import com.zxd.admin.exception.error.ErrorCodeInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;


/**
 * 统一异常类
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class ApiException extends RuntimeException{

    protected ErrorCodeInterface errorCode;

    protected String message;

    protected Object[] args;

    protected String formattedMessage;

    public ApiException(Throwable e, ErrorCodeInterface errorCode, Object ...args) {
        super(e);
        fillErrorCode(errorCode, args);
    }

    public ApiException(ErrorCodeInterface errorCode, Object... args) {
        fillErrorCode(errorCode, args);
    }

    public ApiException(ErrorCodeInterface errorCode) {
        fillErrorCode(errorCode);
    }

    private void fillErrorCode(ErrorCodeInterface errorCode, Object ...args) {
        this.errorCode = errorCode;
        this.message = errorCode.message();
        this.args = args;

        this.formattedMessage = StrUtil.format(this.message, args);
    }
}
