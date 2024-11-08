package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class KickUser {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("platforms")
    private String[] platforms;
    @SerializedName("device_ids")
    private String[] deviceIds;
    private String ext;

    public KickUser() {
    }

    public String getUserId() {
        return userId;
    }

    public KickUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public KickUser setPlatforms(String[] platforms) {
        this.platforms = platforms;
        return this;
    }

    public String[] getDeviceIds() {
        return deviceIds;
    }

    public KickUser setDeviceIds(String[] deviceIds) {
        this.deviceIds = deviceIds;
        return this;
    }

    public String getExt() {
        return ext;
    }

    public KickUser setExt(String ext) {
        this.ext = ext;
        return this;
    }

    @Override
    public String toString() {
        return "KickUser{" +
                "userId='" + userId + '\'' +
                ", platforms=" + Arrays.toString(platforms) +
                ", deviceIds=" + Arrays.toString(deviceIds) +
                ", ext='" + ext + '\'' +
                '}';
    }
}
