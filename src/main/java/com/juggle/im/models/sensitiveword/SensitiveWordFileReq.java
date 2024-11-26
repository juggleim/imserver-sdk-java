package com.juggle.im.models.sensitiveword;

public class SensitiveWordFileReq {

    /**
     * 二进制数组
     */
    private byte[] data;

    /**
     * 文件名
     */
    private String fileName;


    public SensitiveWordFileReq() {
    }

    public byte[] getData() {
        return data;
    }

    public SensitiveWordFileReq setData(byte[] data) {
        this.data = data;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public SensitiveWordFileReq setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
