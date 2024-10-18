package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class UserTagsResult extends Result{
    @SerializedName("data")
    private UserTags userTags;
    public UserTagsResult(Integer code, String errMsg,UserTags userTags){
        super(code, errMsg);
        this.userTags = userTags;
    }

    public UserTags getUserTags(){
        return this.userTags;
    }

    @Override
	public String toString() {
		return GsonUtil.toJson(this, UserTagsResult.class);
	}
}
