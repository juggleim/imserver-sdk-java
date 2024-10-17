package com.juggle.im.models.chatroom;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class ChatroomInfoResult extends Result {
    @SerializedName("data")
    private ChatroomInfo data;
    public ChatroomInfoResult(Integer code, String errMsg, ChatroomInfo chatroom){
        super(code, errMsg);
        this.data = chatroom;
    }
    public ChatroomInfo getChatroomInfo(){
        return this.data;
    }
    @Override
	public String toString() {
		return GsonUtil.toJson(this, ChatroomInfoResult.class);
	}
}
