package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChrmGlobalMuteMemberIds {
    @SerializedName("member_ids")
    public List<String> memberIds;

    public ChrmGlobalMuteMemberIds(List<String> memberIds){
        this.memberIds = memberIds;
    }

    public List<String> getMemberIds(){
        return this.memberIds;
    }
}
