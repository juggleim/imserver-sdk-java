package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChatroomBanMemberIds {
    @SerializedName("chat_id")
    public String chatId;
    @SerializedName("member_ids")
    public List<String> memberIds;

    public ChatroomBanMemberIds(String chatId, List<String> memberIds){
        this.chatId = chatId;
        this.memberIds = memberIds;
    }
}
