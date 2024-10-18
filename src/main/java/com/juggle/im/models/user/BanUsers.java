package com.juggle.im.models.user;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BanUsers {
    @SerializedName("items")
    private List<BanUser> items;
    @SerializedName("offset")
    private String offset;
    
    public BanUsers setBanUsers(List<BanUser> items){
        this.items = items;
        return this;
    }

    public List<BanUser> getItems(){
        return this.items;
    }

    public String getOffset(){
        return this.offset;
    }
}
