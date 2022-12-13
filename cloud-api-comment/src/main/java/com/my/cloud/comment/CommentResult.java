package com.my.cloud.comment;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 16:33
 */
public class CommentResult {
    private Integer code;
    private String msg;
    private Object data;

    public CommentResult() {
    }

    public CommentResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommentResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
