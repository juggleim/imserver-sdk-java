package com.juggle.im.models.chatroom;

import java.util.List;

public class ChatroomMuteMembers {
    private String chatId;
    private List<ChatroomMember> members;
    private String offset;

    public ChatroomMuteMembers(){}

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
