package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

/**
 * 锁定用户对象
 * @date 2024-11-08
 */
public class BlockUsers {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("block_user_ids")
    private String[] blockUserIds;


    public BlockUsers() {
    }

    public String getUserId() {
        return userId;
    }

    public BlockUsers setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String[] getBlockUserIds() {
        return blockUserIds;
    }

    public BlockUsers setBlockUserIds(String[] blockUserIds) {
        this.blockUserIds = blockUserIds;
        return this;
    }
}
