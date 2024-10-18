package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChrmGlobalMuteMembers {
    @SerializedName("members")
    private List<ChatroomMember> members;
    @SerializedName("offset")
    private String offset;
    public ChrmGlobalMuteMembers(){}

    public List<ChatroomMember> getMembers(){
        return this.members;
    }

    public String getOffset(){
        return this.offset;
    }
}
