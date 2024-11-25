package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserStatusRet {

    private List<UserStatusItem> items;

    public UserStatusRet() {
    }

    public List<UserStatusItem> getItems() {
        return items;
    }

    public void setItems(List<UserStatusItem> items) {
        this.items = items;
    }

    static class UserStatusItem {
        @SerializedName("user_id")
        private String userId;
        @SerializedName("is_online")
        private Boolean isOnline;

        public UserStatusItem() {
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Boolean getOnline() {
            return isOnline;
        }

        public void setOnline(Boolean online) {
            isOnline = online;
        }
    }

}
