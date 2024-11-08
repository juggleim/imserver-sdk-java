package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class KickUsersResult extends Result {
    @SerializedName("data")
    private String data;

    public KickUsersResult(Integer code, String errMsg, String data){
        super(code, errMsg);
        this.data = data;
    }


    @Override
	public String toString() {
		return GsonUtil.toJson(this, KickUsersResult.class);
	}
}
