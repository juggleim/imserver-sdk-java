package com.juggle.im.models.chatroom;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChrmMembersExist {
    @SerializedName("items")
    private List<ChrmMemberExistItem> items;

    public ChrmMembersExist(){}

    public List<ChrmMemberExistItem> getItems(){
        return this.items;
    }
}
