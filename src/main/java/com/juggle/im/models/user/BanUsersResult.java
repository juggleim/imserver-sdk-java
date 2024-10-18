package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class BanUsersResult extends Result {
    @SerializedName("data")
    private BanUsers banUsers;

    public BanUsersResult(Integer code, String errMsg, BanUsers banUsers){
        super(code, errMsg);
        this.banUsers = banUsers;
    }

    @Override
	public String toString() {
		return GsonUtil.toJson(this, BanUsersResult.class);
	}
}
