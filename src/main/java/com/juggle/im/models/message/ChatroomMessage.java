package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;

public class ChatroomMessage extends MessageModel{
    @SerializedName("is_notify_sender")
    public Boolean isNotifySender;
     @SerializedName("is_storage")
    public Boolean isStorage;
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
    public String[] getTargetIds() {
        return super.getTargetIds();
    }
    /**
     * 设置接受聊天室Id
     *
     * @return String
     */
    @Override
    public ChatroomMessage setTargetIds(String[] targetId) {
        super.setTargetIds(targetId);
        return this;
    }

    public Boolean getIsStorage() {
        return this.isStorage;
    }

    public ChatroomMessage setIsStorage(Boolean isStorage) {
        this.isStorage = isStorage;
        return this;
    }

    public Boolean getIsNotifySender() {
        return this.isNotifySender;
    }

    public ChatroomMessage setIsNotifySender(Boolean isNotifySender) {
        this.isNotifySender = isNotifySender;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public ChatroomMessage setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }
}
