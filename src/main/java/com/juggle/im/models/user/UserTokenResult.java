package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class UserTokenResult extends Result{
    @SerializedName("data")
    private UserToken data;

    public UserTokenResult(Integer code, String errMsg, UserToken userToken){
        super(code, errMsg);
        this.data = userToken;
    }

    public UserTokenResult setUserToken(UserToken userToken){
        this.data = userToken;
        return this;
    }

    public UserToken getUserToken(){
        return this.data;
    }

    @Override
	public String toString() {
		return GsonUtil.toJson(this, UserTokenResult.class);
	}
}
