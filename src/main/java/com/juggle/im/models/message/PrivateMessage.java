package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.messages.BaseMessage;

public class PrivateMessage extends MessageModel{
    @SerializedName("is_storage")
    public Boolean isPersisted;
    @SerializedName("is_count")
    public Boolean isCounted;
    @SerializedName("is_notify_sender")
    public Boolean isIncludeSender;

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
    public String[] getTargetId() {
        return super.getTargetId();
    }

    /**
     * 设置接受用户id
     */
    @Override
    public PrivateMessage setTargetId(String[] targetId) {
        super.setTargetId(targetId);
        return this;
    }

    @Override
    public PrivateMessage setContent(BaseMessage content) {
        super.setContent(content);
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

    public Boolean getIsPersisted() {
        return this.isPersisted;
    }

    public PrivateMessage setIsPersisted(Boolean isPersisted) {
        this.isPersisted = isPersisted;
        return this;
    }

    public Boolean getIsCounted() {
        return this.isCounted;
    }

    public PrivateMessage setIsCounted(Boolean isCounted) {
        this.isCounted = isCounted;
        return this;
    }

    public Boolean getIsIncludeSender() {
        return this.isIncludeSender;
    }

    public PrivateMessage setIsIncludeSender(Boolean isIncludeSender) {
        this.isIncludeSender = isIncludeSender;
        return this;
    }
}

