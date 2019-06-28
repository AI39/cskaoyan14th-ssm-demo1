package com.cskaoyan14th.util;

/**
 * 注册到容器中，方便改变文件上传的真实路径
 */
public class UploadRealPath {
    String picPath;
    String filePath;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
