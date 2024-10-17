package com.juggle.im.models;

import com.google.gson.annotations.SerializedName;

public abstract class Result {
    @SerializedName("code")
    public Integer code;
    /**
     * 错误信息。
     *
     */
    @SerializedName("msg")
    public String errorMessage;

    public String requestId;

    public Result(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public Result() {

    }
    /**
     * 设置code
     *
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取code
     *
     * @return Integer
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取错误信息
     *
     * @return String
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    /**
     * 设置错误信息 msg
     *
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public abstract String toString();
}
