package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChrmMemberIds {
    @SerializedName("chat_id")
    private String chatId;
    @SerializedName("member_ids")
    private List<String> memberIds;

    public ChrmMemberIds(String chatId,List<String> memberIds){
        this.chatId = chatId;
        this.memberIds = memberIds;
    }

    public String getChatId(){
        return this.chatId;
    }

    public List<String> getMemberIds(){
        return this.memberIds;
    }
}
