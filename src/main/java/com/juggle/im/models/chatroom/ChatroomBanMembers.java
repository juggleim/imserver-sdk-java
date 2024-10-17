package com.juggle.im.models.chatroom;

import java.util.List;

public class ChatroomBanMembers {
    private String chatId;
    private List<ChatroomMember> members;
    private String offset;

    public ChatroomBanMembers(){}

    public String getChatId(){
        return this.chatId;
    }

    public List<ChatroomMember> getMembers(){
        return this.members;
    }

    public String getOffset(){
        return this.offset;
    }
}
