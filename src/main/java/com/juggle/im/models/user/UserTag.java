package com.juggle.im.models.user;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UserTag {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("tags")
    private List<String> tags;
    
    public UserTag(){}

    public UserTag setUserId(String userId){
        this.userId = userId;
        return this;
    }

    public String getUserId(){
        return this.userId;
    }

    public UserTag setTags(List<String> tags){
        this.tags = tags;
        return this;
    }

    public List<String> getTags(){
        return this.tags;
    }
}
