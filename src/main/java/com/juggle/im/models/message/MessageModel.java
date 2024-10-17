package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.messages.BaseMessage;
import com.juggle.im.util.GsonUtil;

public class MessageModel{
    @SerializedName("sender_id")
    private String senderId;
    @SerializedName("target_ids")
    private String[] targetId;
    @SerializedName("msg_type")
    private String objectName;
    @SerializedName("msg_content")
    private BaseMessage content;
    private String pushContent;
    private String pushExt;

    public MessageModel(){}

    public String[] getTargetId() {
        return this.targetId;
    }

    public MessageModel setTargetId(String[] targetId) {
        this.targetId = targetId;
        return this;
    }

    @Deprecated
    public MessageModel setObjectName(String objectName) {
        this.objectName = objectName;
        return this;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public BaseMessage getContent() {
        return this.content;
    }

    public MessageModel setContent(BaseMessage content) {
        this.content = content;
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
