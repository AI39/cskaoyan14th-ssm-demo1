package com.cskaoyan14th.vo;

/**
 * 文件上传的返回信息对象
 */

public class UploadMsg {
    private int error;
    private String url;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrl(String fileType, String filePath) {
        this.url = "/" + fileType + "/" + filePath;
    }

    @Override
    public String toString() {
        return "UploadMsg{" +
                "error='" + error + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
