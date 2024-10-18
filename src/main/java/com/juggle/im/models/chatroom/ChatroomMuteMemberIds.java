package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChatroomMuteMemberIds {
    @SerializedName("chat_id")
    private String chatId;
    @SerializedName("member_ids")
    private List<String> memberIds;

    public ChatroomMuteMemberIds(String chatId, List<String> memberIds){
        this.chatId = chatId;
        this.memberIds = memberIds;
    }

    public List<String> getMemberIds(){
        return this.memberIds;
    }

    public String getChatId(){
        return this.chatId;
    }
}
