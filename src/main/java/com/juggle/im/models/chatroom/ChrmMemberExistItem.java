package com.juggle.im.models.chatroom;

import com.google.gson.annotations.SerializedName;

public class ChrmMemberExistItem {
    @SerializedName("member_id")
    private String memberId;
    @SerializedName("exist")
    private boolean exist;
    public ChrmMemberExistItem(){}

    public String getMemberId(){
        return this.memberId;
    }
    public boolean IsExist(){
        return this.exist;
    }
}
