package com.juggle.im.models.chatroom;

import com.google.gson.annotations.SerializedName;

public class ChatroomAtt {
    @SerializedName("key")
    private String key;
    @SerializedName("value")
    private String value;
    @SerializedName("att_time")
    private long attTime;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("is_force")
    private Boolean isForce;

    public ChatroomAtt(String key, String value,Boolean isForce){
        this.key = key;
        this.value = value;
        this.isForce = isForce;
    }

    public String getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    public long getAttTime(){
        return this.attTime;
    }

    public String getUserId(){
        return this.userId;
    }

    public Boolean isForce(){
        return this.isForce;
    }
}
