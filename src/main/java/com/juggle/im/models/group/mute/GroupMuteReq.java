package com.juggle.im.models.group.mute;

import com.google.gson.annotations.SerializedName;

public class GroupMuteReq {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("is_mute")
    private Integer isMute;

    public GroupMuteReq() {
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupMuteReq setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getIsMute() {
        return isMute;
    }

    public GroupMuteReq setIsMute(Integer isMute) {
        this.isMute = isMute;
        return this;
    }
}
