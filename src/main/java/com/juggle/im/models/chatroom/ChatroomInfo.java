package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChatroomInfo {
    @SerializedName("chat_id")
    private String chatId;
    @SerializedName("chat_name")
    private String chatName;
    @SerializedName("member_count")
    private int memberCount;
    @SerializedName("is_mute")
    private int isMute;

    @SerializedName("members")
    private List<ChatroomMember> members;
    @SerializedName("atts")
    private List<ChatroomAtt> atts;

    public ChatroomInfo(String chatId, String chatName){
        this.chatId = chatId;
        this.chatName = chatName;
    }

    public ChatroomInfo setChatId(String chatId){
        this.chatId = chatId;
        return this;
    }

    public String getChatId(){
        return this.chatId;
    }

    public ChatroomInfo setChatName(String chatName){
        this.chatName = chatName;
        return this;
    }

    public String getChatName(){
        return this.chatName;
    }

    public int getMemberCount(){
        return this.memberCount;
    }

    public ChatroomInfo setIsMute(int isMute){
        this.isMute = isMute;
        return this;
    }

    public int getIsMute(){
        return this.isMute;
    }

    public List<ChatroomMember> getMembers(){
        return this.members;
    }

    public List<ChatroomAtt> getChatroomAtts(){
        return this.atts;
    }
}
