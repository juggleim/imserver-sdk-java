package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GroupMemReq {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("ext_fields")
    private Map<String, String> extFields;

    @SerializedName("member_ids")
    private List<String> memberIds;

    public GroupMemReq() {
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupMemReq setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }

    public GroupMemReq setExtFields(Map<String, String> extFields) {
        this.extFields = extFields;
        return this;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }

    @Override
    public String toString() {
        return "GroupMemReq{" +
                "groupId='" + groupId + '\'' +
                ", extFields=" + extFields +
                ", memberIds=" + memberIds +
                '}';
    }

}
