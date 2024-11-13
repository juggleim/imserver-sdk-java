package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GroupUpd {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("group_name")
    private String groupName;

    @SerializedName("group_portrait")
    private String groupPortrait;

    @SerializedName("ext_fields")
    private Map<String, String> extFields;

    public GroupUpd() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPortrait() {
        return groupPortrait;
    }

    public void setGroupPortrait(String groupPortrait) {
        this.groupPortrait = groupPortrait;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }

    public void setExtFields(Map<String, String> extFields) {
        this.extFields = extFields;
    }

}
