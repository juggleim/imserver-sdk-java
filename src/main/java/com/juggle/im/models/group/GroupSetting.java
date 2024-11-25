package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GroupSetting {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("settings")
    private Map<String, String> settings;

    public GroupSetting() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
}
