package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;

public class PrivateMessage extends MessageModel{
    @SerializedName("is_storage")
    public Boolean isStorage;
    @SerializedName("is_count")
    public Boolean isCount;
    @SerializedName("is_notify_sender")
    public Boolean isNotifySender;

    @Override
    public PrivateMessage setSenderId(String senderId) {
        super.setSenderId(senderId);
        return this;
    }

    /**
     * 获取接受用户id
     *
     * @return String
     */
    @Override
    public String[] getTargetIds() {
        return super.getTargetIds();
    }

    /**
     * 设置接受用户id
     */
    @Override
    public PrivateMessage setTargetIds(String[] targetId) {
        super.setTargetIds(targetId);
        return this;
    }

    @Override
    public PrivateMessage setPushContent(String pushContent) {
        super.setPushContent(pushContent);
        return this;
    }

    @Override
    public PrivateMessage setPushExt(String pushExt) {
        super.setPushExt(pushExt);
        return this;
    }

    public Boolean getIsStorage() {
        return this.isStorage;
    }

    public PrivateMessage setIsStorage(Boolean isStorage) {
        this.isStorage = isStorage;
        return this;
    }

    public Boolean getIsCount() {
        return this.isCount;
    }

    public PrivateMessage setIsCount(Boolean isCount) {
        this.isCount = isCount;
        return this;
    }

    public Boolean getIsNotifySender() {
        return this.isNotifySender;
    }

    public PrivateMessage setIsNotifySender(Boolean isNotifySender) {
        this.isNotifySender = isNotifySender;
        return this;
    }
}

