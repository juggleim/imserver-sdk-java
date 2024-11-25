package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Map;

public class GroupMemberModel {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("group_name")
    private String groupName;

    @SerializedName("group_portrait")
    private String groupPortrait;

    @SerializedName("ext_fields")
    private Map<String, String> extFields;

    @SerializedName("member_ids")
    private String [] memberIds;

    public GroupMemberModel() {
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupMemberModel setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public GroupMemberModel setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupPortrait() {
        return groupPortrait;
    }

    public GroupMemberModel setGroupPortrait(String groupPortrait) {
        this.groupPortrait = groupPortrait;
        return this;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }

    public GroupMemberModel setExtFields(Map<String, String> extFields) {
        this.extFields = extFields;
        return this;
    }

    public String[] getMemberIds() {
        return memberIds;
    }

    public GroupMemberModel setMemberIds(String[] memberIds) {
        this.memberIds = memberIds;
        return this;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupPortrait='" + groupPortrait + '\'' +
                ", extFields=" + extFields +
                ", memberIds=" + Arrays.toString(memberIds) +
                '}';
    }

}
