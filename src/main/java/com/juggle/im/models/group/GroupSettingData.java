package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

public class GroupSettingData {

    @SerializedName("groupId")
    private String groupId;

    @SerializedName("extFields")
    private ExtFields[] extFields;

    public GroupSettingData() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ExtFields[] getExtFields() {
        return extFields;
    }

    public void setExtFields(ExtFields[] extFields) {
        this.extFields = extFields;
    }

    static class ExtFields {

        @SerializedName("key")
        private String key;

        @SerializedName("value")
        private String value;

        @SerializedName("updTime")
        private Long updateTime;

        public ExtFields() {
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }

}
