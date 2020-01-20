package com.fh.uitl;

public enum ServerEnum {



    ACCOUNT_OR_PWD_ISNULL(1001,"账号或者密码不存在"),
    ACCOUNT_ERROR(5001,"账号异常，请联系管理员")
    ,ACCOUNT_NOT_EXIST(1002,"账号不存在请联系管理员")
    ,ACCOUNT_NOT_INVALID(1003,"账号无效请联系管理员")
    ,PWD_ERROR(1004,"密码输入有误，请重新输入")
    ,RIGHT_NO(1005,"该用户没有权限访问，请联系管理员")
    ,SUCCESS(200,"成功")
    ,ERROR(500,"失败")
    ;
    private ServerEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
    private Integer code;
    private String message;


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
