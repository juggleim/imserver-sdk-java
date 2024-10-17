package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.messages.BaseMessage;

public class ChatroomMessage extends MessageModel{
    @SerializedName("is_notify_sender")
    public Boolean isIncludeSender;
     @SerializedName("is_storage")
    public Boolean isPersisted;
    @SerializedName("priority")
    public Integer priority = null;

    public ChatroomMessage(){}


   @Override
    public ChatroomMessage setSenderId(String senderId) {
        super.setSenderId(senderId);
        return this;
    }
    /**
     * 获取接受聊天室Id
     *
     * @return String
     */
    @Override
    public String[] getTargetId() {
        return super.getTargetId();
    }
    /**
     * 设置接受聊天室Id
     *
     * @return String
     */
    @Override
    public ChatroomMessage setTargetId(String[] targetId) {
        super.setTargetId(targetId);
        return this;
    }
    @Override
    public ChatroomMessage setObjectName(String objectName) {
        super.setObjectName(objectName);
        return this;
    }

    public Boolean getIsPersisted() {
        return this.isPersisted;
    }

    public ChatroomMessage setIsPersisted(Boolean isPersisted) {
        this.isPersisted = isPersisted;
        return this;
    }

    public Boolean getIsIncludeSender() {
        return this.isIncludeSender;
    }

    public ChatroomMessage setIsIncludeSender(Boolean isIncludeSender) {
        this.isIncludeSender = isIncludeSender;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public ChatroomMessage setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public ChatroomMessage setContent(BaseMessage content) {
        super.setContent(content);
        return this;
    }
}
