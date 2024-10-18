package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChrmGlobalMuteMemberIds {
    @SerializedName("member_ids")
    public List<String> memberIds;
    @SerializedName("end_time")
    public long endTime;
    @SerializedName("end_time_offset")
    public long endTimeOffset;

    public ChrmGlobalMuteMemberIds(List<String> memberIds,long endTime,long endTimeOffset){
        this.memberIds = memberIds;
        this.endTime = endTime;
        this.endTimeOffset = endTimeOffset;
    }

    public List<String> getMemberIds(){
        return this.memberIds;
    }
}
