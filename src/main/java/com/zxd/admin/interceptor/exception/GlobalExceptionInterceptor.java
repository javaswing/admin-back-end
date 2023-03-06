package com.zxd.admin.interceptor.exception;

import com.zxd.admin.core.vo.BaseResponseVO;
import com.zxd.admin.enums.ResponseShowType;
import com.zxd.admin.exception.ApiException;
import com.zxd.admin.exception.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionInterceptor {

    /**
     * 业务异常捕捉
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public BaseResponseVO<?> handleServiceException(ApiException e) {
        log.error(e.getMessage(), e);
        return BaseResponseVO.fail(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponseVO<?> handleRunTimeException(RuntimeException e, HttpServletRequest request) {
        log.error("请求地址{}，发生未知异常", request.getRequestURI(), e);
        return BaseResponseVO.fail(
                ErrorCode.Internal.UNKNOWN_ERROR.code(),
                ErrorCode.Internal.UNKNOWN_ERROR.message());
    }
}
