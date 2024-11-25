package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class BlockUsersResult extends Result {
    @SerializedName("data")
    private BlockUserRet blockUserRet;

    public BlockUsersResult(Integer code, String errMsg, BlockUserRet blockUserRet){
        super(code, errMsg);
        this.blockUserRet = blockUserRet;
    }

    public BlockUserRet getBlockUserRet() {
        return blockUserRet;
    }

    public void setBlockUserRet(BlockUserRet blockUserRet) {
        this.blockUserRet = blockUserRet;
    }

    @Override
    public String toString() {
        return "BlockUsersResult{" +
                "blockUserRet=" + blockUserRet +
                '}';
    }
}
