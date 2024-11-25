package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class BlockUserRet {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("items")
    private BlockUserItem[] items;
    @SerializedName("offset")
    private String offset;


    static class BlockUserItem {

        @SerializedName("block_user_id")
        private String blockUserId;

        @SerializedName("createed_time")
        private Long createTime;

        public BlockUserItem() {
        }

        public String getBlockUserId() {
            return blockUserId;
        }

        public void setBlockUserId(String blockUserId) {
            this.blockUserId = blockUserId;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return "BlockUserItem{" +
                    "blockUserId='" + blockUserId + '\'' +
                    ", createTime=" + createTime +
                    '}';
        }
    }


    public BlockUserRet() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BlockUserItem[] getItems() {
        return items;
    }

    public void setItems(BlockUserItem[] items) {
        this.items = items;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "BlockUserRet{" +
                "userId='" + userId + '\'' +
                ", items=" + Arrays.toString(items) +
                ", offset='" + offset + '\'' +
                '}';
    }
}
