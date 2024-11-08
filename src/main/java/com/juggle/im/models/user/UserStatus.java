package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class UserStatus {

    @SerializedName("user_ids")
    private String[] userIds;


    public UserStatus() {
    }

    public String[] getUserIds() {
        return userIds;
    }

    public UserStatus setUserIds(String[] userIds) {
        this.userIds = userIds;
        return this;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "userIds=" + Arrays.toString(userIds) +
                '}';
    }

}
