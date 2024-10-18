package com.juggle.im.models.user;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BanUsers {
    @SerializedName("data")
    private List<BanUser> users;
    @SerializedName("offset")
    private String offset;
    
    public BanUsers setBanUsers(List<BanUser> users){
        this.users = users;
        return this;
    }

    public List<BanUser> getBanUsers(){
        return this.users;
    }

    public String getOffset(){
        return this.offset;
    }
}
