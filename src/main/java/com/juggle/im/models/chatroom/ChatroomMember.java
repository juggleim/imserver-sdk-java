package com.juggle.im.models.chatroom;

import com.google.gson.annotations.SerializedName;

public class ChatroomMember {
    @SerializedName("member_id")
    private String memberId;
    @SerializedName("member_name")
    private String memberName;
    @SerializedName("added_time")
    private long addedTime;

    public ChatroomMember(String memberId, String memberName){
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public ChatroomMember setMemberId(String memberId){
        this.memberId = memberId;
        return this;
    }

    public String getMemberId(){
        return this.memberId;
    }

    public ChatroomMember setMemberName(String memberName){
        this.memberName = memberName;
        return this;
    }

    public String getMemberName(){
        return this.memberName;
    }

    public long getAddedTime(){
        return this.addedTime;
    }
}
