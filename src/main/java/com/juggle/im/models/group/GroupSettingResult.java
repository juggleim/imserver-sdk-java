package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class GroupSettingResult extends Result {

    @SerializedName("data")
    private GroupSettingData data;

    public GroupSettingResult(Integer code, String errMsg, GroupSettingData groupSetting){
        super(code, errMsg);
        this.data = groupSetting;
    }
    public GroupSettingData getGroupSettingRes(){
        return this.data;
    }
    @Override
    public String toString() {
        return GsonUtil.toJson(this, GroupSettingResult.class);
    }


}
