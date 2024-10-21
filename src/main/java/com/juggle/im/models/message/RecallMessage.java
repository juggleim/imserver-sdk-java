package com.juggle.im.models.message;

import com.google.gson.annotations.SerializedName;

public class RecallMessage {
    /**
     * 撤回消息的会话类型
     */
    @SerializedName("channel_type")
    public int converType;
     /**
     * 撤回消息体
     * 发送人id
     */
    @SerializedName("from_id")
    public String senderId;
    /**
     * 接收人id
     */
    @SerializedName("target_id")
    public String targetId;
    /**
     * 消息唯一标识 各端 SDK 发送消息成功后会返回 uId
     */
    @SerializedName("msg_id")
    public String msgId;
    /**
     * 消息的发送时间，各端 SDK 发送消息成功后会返回 sentTime
     */
    @SerializedName("msg_time")
    public long msgTime;

    /**
     * 扩展信息，可以放置任意的数据内容（可选）。
     */
    @SerializedName("exts")
    public String extra;

    public RecallMessage() {
    }

    /**
     * @param senderId         String	消息发送人用户 Id。（必传）
     * @param converType Int	会话类型，二人会话是 1 、群组会话是 2 、聊天室会话是 3 。（必传）
     * @param targetId         String	目标 Id，根据不同的 ConversationType，可能是用户 Id、群组 Id、聊天室 Id。（必传）
     * @param msgId              String	消息唯一标识: msgId。（必传）
     * @param sentTime
     */
    public RecallMessage(int converType,String senderId, String targetId,
                         String msgId, long msgTime, String extra) {
        this.senderId = senderId;
        this.targetId = targetId;
        this.msgTime = msgTime;
        this.msgId = msgId;
        this.extra = extra;
        this.converType = converType;
    }

    public int getConverType(){
        return this.converType;
    }

    public RecallMessage setConverType(int converType){
        this.converType = converType;
        return this;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public RecallMessage setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public RecallMessage setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public RecallMessage setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public RecallMessage setMsgTime(long msgTime) {
        this.msgTime = msgTime;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public RecallMessage setExtra(String extra) {
        this.extra = extra;
        return this;
    }
}
