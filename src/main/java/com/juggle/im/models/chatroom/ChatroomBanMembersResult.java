package com.juggle.im.models.chatroom;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class ChatroomBanMembersResult extends Result{
    @SerializedName("data")
    private ChatroomBanMembers data;
    public ChatroomBanMembersResult(Integer code, String errMsg, ChatroomBanMembers chatroom){
        super(code, errMsg);
        this.data = chatroom;
    }
    public ChatroomBanMembers getChatroomMuteMembers(){
        return this.data;
    }
    @Override
	public String toString() {
		return GsonUtil.toJson(this, ChatroomBanMembersResult.class);
	}
}
