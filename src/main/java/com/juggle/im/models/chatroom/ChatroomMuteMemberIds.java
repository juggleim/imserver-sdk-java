package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChatroomMuteMemberIds {
    @SerializedName("chat_id")
    private String chatId;
    @SerializedName("member_ids")
    private List<String> memberIds;
    @SerializedName("end_time")
    public long endTime;
    @SerializedName("end_time_offset")
    public long endTimeOffset;

    public ChatroomMuteMemberIds(String chatId, List<String> memberIds,long endTime,long endTimeOffset){
        this.chatId = chatId;
        this.memberIds = memberIds;
        this.endTime = endTime;
        this.endTimeOffset = endTimeOffset;
    }

    public List<String> getMemberIds(){
        return this.memberIds;
    }

    public String getChatId(){
        return this.chatId;
    }
}
