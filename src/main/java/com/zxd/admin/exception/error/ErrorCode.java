package com.zxd.admin.exception.error;

public enum ErrorCode implements ErrorCodeInterface {


    /**
     * 错误码集合
     * 200 为正常处理
     * 1~9999 为保留错误码 或者 常用错误码
     * 10000~19999 为内部错误码
     * 20000~29999 客户端错误码 （客户端异常调用之类的错误）
     * 30000~39999 为第三方错误码 （代码正常，但是第三方异常）
     * 40000~49999 为业务逻辑 错误码 （无异常，代码正常流转，并返回提示给用户）
     * 由于系统内的错误码都是独一无二的，所以错误码应该放在common包集中管理
     * @link https://github.com/valarchie/AgileBoot-Back-End/blob/main/agileboot-common/src/main/java/com/agileboot/common/exception/error/ErrorCode.java
     */
    SUCCESS(200, "操作成功"),
    FAIL(999, "操作失败"),
    NO_LOGIN(401, "未登录"),
    UNKNOWN_ERROR(9999, "未知异常");


    private final int code;

    private final String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

    /**
     * 40000~49999 为业务逻辑 错误码 （无代码异常，代码正常流转，并返回提示给用户）
     */
    public enum Business implements ErrorCodeInterface {

        // ========================= user =======================
        USER_ACCOUNT_IS_NOT_UNIQUE(Module.USER, 13, "用户名已经被其它用户占用"),
        USER_EMAIL_IS_NOT_UNIQUE(Module.USER, 14, "当前邮箱已经被其它用户占用"),
        USER_MOBILE_IS_NOT_UNIQUE(Module.USER, 14, "当前手机已经被其它用户占用");

        private final int code;
        private final String msg;

        private static final int BASE_CODE = 40000;

        Business(Module module, int code, String msg) {
            this.code = BASE_CODE + module.code() + code;
            this.msg = msg;
        }

        @Override
        public int code() {
            return this.code;
        }

        @Override
        public String message() {
            return this.msg;
        }
    }
}
