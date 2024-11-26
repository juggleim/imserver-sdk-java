package com.juggle.im.models.sensitiveword;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class SensitiveWordResult extends Result {

    @SerializedName("data")
    private SensitiveWordData data;

    public SensitiveWordResult(Integer code, String errorMessage) {
        super(code, errorMessage);
    }

    public SensitiveWordData getData() {
        return data;
    }

    public void setData(SensitiveWordData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, SensitiveWordResult.class);
    }
}
