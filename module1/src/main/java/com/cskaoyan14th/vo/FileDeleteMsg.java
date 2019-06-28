package com.cskaoyan14th.vo;

/**
 * 删除文件时返回给前端的json对象
 */
public class FileDeleteMsg {
    private String data;

    public FileDeleteMsg(){}
    public FileDeleteMsg(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
