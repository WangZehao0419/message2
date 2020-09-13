package cn.wzh.vo;

import cn.wzh.enums.Result;


public class JSONResultVO<T> {
    private String code;
    private String message;
    private T data;

    public JSONResultVO(Result result, T data) {
        this.code = result.getCode();
        this.message = result.getMessage();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}





