package com.juggle.im.models.user;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UserTags {
    @SerializedName("user_tags")
    private List<UserTag> userTags;

    public UserTags(){}

    public UserTags setUserTags(List<UserTag> userTags){
        this.userTags = userTags;
        return this;
    }

    public List<UserTag> getUserTags(){
        return this.userTags;
    }
}
