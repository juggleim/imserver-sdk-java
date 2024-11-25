package com.juggle.im.models.group.mute;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupMemMuteReq {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("member_ids")
    private List<String> memberIds;

    @SerializedName("is_mute")
    private Integer isMute;

    @SerializedName("mute_minute")
    private Integer muteMinute;

    public GroupMemMuteReq() {
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupMemMuteReq setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public GroupMemMuteReq setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
        return this;
    }

    public Integer getIsMute() {
        return isMute;
    }

    public GroupMemMuteReq setIsMute(Integer isMute) {
        this.isMute = isMute;
        return this;
    }

    public Integer getMuteMinute() {
        return muteMinute;
    }

    public GroupMemMuteReq setMuteMinute(Integer muteMinute) {
        this.muteMinute = muteMinute;
        return this;
    }
}
