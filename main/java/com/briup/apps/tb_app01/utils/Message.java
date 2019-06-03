package com.briup.apps.tb_app01.utils;

/**
 * @program: tb_app01
 * @description: 自定义消息类
 * @author: charles
 * @create: 2019-04-30 15:28
 **/
public class Message {
    private Integer status;
    private String message;
    private Object data;
    private Long timestamp;

    public Message() {
    }

    public Message(Integer status, String message, Object data, Long timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
