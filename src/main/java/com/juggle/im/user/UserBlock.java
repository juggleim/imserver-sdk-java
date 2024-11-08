package com.juggle.im.user;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.user.*;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;


import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class UserBlock {

    private JuggleIm juggleim;

    public UserBlock(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public ResponseResult block(BlockUsers blockUsers) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/blockusers/block";
        String body = GsonUtil.toJson(blockUsers);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ResponseResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ResponseResult) GsonUtil.fromJson(response, ResponseResult.class);
        } catch (Exception e) {
            result = new ResponseResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage());
        }
        return result;
    }

    public ResponseResult unblock(BlockUsers blockUsers) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/blockusers/unblock";
        String body = GsonUtil.toJson(blockUsers);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ResponseResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ResponseResult) GsonUtil.fromJson(response, ResponseResult.class);
        } catch (Exception e) {
            result = new ResponseResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage());
        }
        return result;
    }

    public BlockUsersResult qryBlockUsers(BlockUserQry query) throws Exception {
        StringBuilder params = new StringBuilder();
        params.append(this.juggleim.getApiUrl()).append("/apigateway/users/blockusers/query?");
        params.append("user_id=");
        params.append(URLEncoder.encode(query.getUserId()));
        params.append("&limit=");
        params.append(query.getLimit());
        params.append("&offset=");
        params.append(query.getOffset());

        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), params.toString());
        String response = "";
        BlockUsersResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (BlockUsersResult) GsonUtil.fromJson(response, BlockUsersResult.class);
        } catch (Exception e) {
            result = new BlockUsersResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }


}
