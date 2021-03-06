package com.miaosha.error;

public enum EmBusinessError implements CommonError {

    //1000开头为通用错误类型定义
    PARAMETER_VALIDATINO_ERROR(10001, "参数不合法"),
    //未知错误
    UNKNOWN_ERROR(10002, "未知错误"),

    //2000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001, "用户不存在"),

    //其他错误信息。。。。。

    ;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
