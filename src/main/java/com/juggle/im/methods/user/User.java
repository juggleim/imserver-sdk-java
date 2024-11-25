package com.juggle.im.methods.user;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.user.*;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

public class User {
    private JuggleIm juggleim;

    public UserBan userBan;
    public TagUser tagUser;
    public UserBlock userBlock;

    public User(JuggleIm juggleim) {
        this.juggleim = juggleim;
        this.userBan = new UserBan(this.juggleim);
        this.tagUser = new TagUser(this.juggleim);
        this.userBlock = new UserBlock(this.juggleim);
    }

    public UserTokenResult register(UserInfo user) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/register";
        String body = GsonUtil.toJson(user);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        UserTokenResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (UserTokenResult) GsonUtil.fromJson(response, UserTokenResult.class);
        } catch (Exception e) {
            result = new UserTokenResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public UserInfoResult get(String userId) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/info?user_id=" + URLEncoder.encode(userId, "UTF-8");
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        String response = "";
        UserInfoResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (UserInfoResult) GsonUtil.fromJson(response, UserInfoResult.class);
        } catch (Exception e) {
            result = new UserInfoResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public UserTokenResult update(UserInfo user) throws Exception {
        // is need to check params before send http
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/update";
        String body = GsonUtil.toJson(user);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        UserTokenResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (UserTokenResult) GsonUtil.fromJson(response, UserTokenResult.class);
        } catch (Exception e) {
            result = new UserTokenResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public KickUsersResult kick(KickUser kickUser) throws Exception {
        // is need to check params before send http?
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/kick";
        String body = GsonUtil.toJson(kickUser);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        KickUsersResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (KickUsersResult) GsonUtil.fromJson(response, KickUsersResult.class);
        } catch (Exception e) {
            result = new KickUsersResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public UserStatusResult qryOnlineStatusByUserIds(UserStatus userStatus) throws Exception {
        // is need to check params before send http?
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/users/onlinestatus/query";
        String body = GsonUtil.toJson(userStatus);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        UserStatusResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (UserStatusResult) GsonUtil.fromJson(response, UserStatusResult.class);
        } catch (Exception e) {
            result = new UserStatusResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

}
