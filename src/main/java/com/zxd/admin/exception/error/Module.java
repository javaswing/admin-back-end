package com.zxd.admin.exception.error;

/**
 * 系统内的模块
 */
public enum Module {

    /**
     * 用户模块
     */
    USER(5);

    private final int code;


    Module(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }
}
