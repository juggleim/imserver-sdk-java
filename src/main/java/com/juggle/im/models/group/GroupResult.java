package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class GroupResult extends Result {
    @SerializedName("data")
    private GroupInfo data;
    public GroupResult(Integer code, String errMsg, GroupInfo groupRes){
        super(code, errMsg);
        this.data = groupRes;
    }
    public GroupInfo getGroupRes(){
        return this.data;
    }
    @Override
	public String toString() {
		return GsonUtil.toJson(this, GroupResult.class);
	}
}
