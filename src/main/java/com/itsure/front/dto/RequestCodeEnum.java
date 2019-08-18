package com.itsure.front.dto;

public enum RequestCodeEnum {
    SUCCESS("200","成功"),
    ERROR("300","失败"),
    DB_EXCEPTION("110","数据库异常"),
    SERVER_ERROR("500","服务器错误");

    private String code;
    private String msg;
    RequestCodeEnum(String code , String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
