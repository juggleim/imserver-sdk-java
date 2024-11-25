package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class UserStatusResult extends Result {
    @SerializedName("data")
    private UserStatusRet data;

    public UserStatusResult(Integer code, String errMsg, UserStatusRet data){
        super(code, errMsg);
        this.data = data;
    }

    @Override
	public String toString() {
		return GsonUtil.toJson(this, UserStatusResult.class);
	}
}
