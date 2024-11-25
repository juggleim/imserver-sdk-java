package com.juggle.im.models.group.mute;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupMemAllowReq {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("member_ids")
    private List<String> memberIds;

    @SerializedName("is_allow")
    private Integer isAllow;

    public GroupMemAllowReq() {
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupMemAllowReq setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public GroupMemAllowReq setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
        return this;
    }

    public Integer getIsAllow() {
        return isAllow;
    }

    public GroupMemAllowReq setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
        return this;
    }
}
