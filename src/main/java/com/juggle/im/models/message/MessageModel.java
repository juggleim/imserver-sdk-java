package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.messages.BaseMessage;

public class MessageModel{
    @SerializedName("sender_id")
    private String senderId;
    @SerializedName("target_ids")
    private String[] targetIds;
    @SerializedName("msg_type")
    private String msgType;
    @SerializedName("msg_content")
    private String msgContent;
    
    private String pushContent;
    private String pushExt;

    public MessageModel(){}

    public String[] getTargetIds() {
        return this.targetIds;
    }

    public MessageModel setTargetIds(String[] targetIds) {
        this.targetIds = targetIds;
        return this;
    }

    public MessageModel setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public MessageModel setMsgContent(String content) {
        this.msgContent = content;
        return this;
    }

     public MessageModel setMsgContent(BaseMessage baseMessage){
        this.setMsgContent(baseMessage.toString());
        this.setMsgType(baseMessage.getType());
        return this;
    }

    public String getPushContent() {
        return this.pushContent;
    }

    public MessageModel setPushContent(String pushContent) {
        this.pushContent = pushContent;
        return this;
    }

    public String getPushExt() {
        return this.pushExt;
    }

    public MessageModel setPushExt(String pushExt) {
        this.pushExt = pushExt;
        return this;
    }


    public String getSenderId() {
        return this.senderId;
    }

    public MessageModel setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }
}
