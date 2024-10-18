package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChatroomBanMemberIds {
    @SerializedName("chat_id")
    public String chatId;
    @SerializedName("member_ids")
    public List<String> memberIds;
    @SerializedName("end_time")
    public long endTime;
    @SerializedName("end_time_offset")
    public long endTimeOffset;

    public ChatroomBanMemberIds(String chatId, List<String> memberIds,long endTime,long endTimeOffset){
        this.chatId = chatId;
        this.memberIds = memberIds;
        this.endTime = endTime;
        this.endTimeOffset = endTimeOffset;
    }
}
