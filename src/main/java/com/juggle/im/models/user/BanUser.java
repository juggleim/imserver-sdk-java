package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

public class BanUser {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("created_time")
    private long createdTime;
    @SerializedName("end_time")
    private long endTime;
    @SerializedName("end_time_offset")
    private long endTimeOffset;
    @SerializedName("scope_key")
    private String scopeKey;
    @SerializedName("scope_value")
    private String scopeValue;
    @SerializedName("ext")
    private String ext;

    public BanUser(){}

    public BanUser setUserId(String userId){
        this.userId = userId;
        return this;
    }

    public String getUserId(){
        return this.userId;
    }

    public long getCreatedTime(){
        return this.createdTime;
    }

    public BanUser setEndTime(long endTime){
        this.endTime = endTime;
        return this;
    }

    public long getEndTime(){
        return this.endTime;
    }

    public BanUser setEndTimeOffset(long offset){
        this.endTimeOffset = offset;
        return this;
    }

    public long getEndTimeOffset(){
        return this.endTimeOffset;
    }

    public BanUser setScopeKey(String scopeKey){
        this.scopeKey = scopeKey;
        return this;
    }

    public String getScopeKey(){
        return this.scopeKey;
    }

    public BanUser setScopeValue(String scopeValue){
        this.scopeValue = scopeValue;
        return this;
    }

    public String getScopeValue(){
        return this.scopeValue;
    }

    public BanUser setExt(String ext){
        this.ext = ext;
        return this;
    }

    public String getExt(){
        return this.ext;
    }
}
