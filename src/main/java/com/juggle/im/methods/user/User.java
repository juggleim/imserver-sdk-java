package com.juggle.im.methods.user;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.user.*;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * 类 {@code SensitiveWord } 用户相关操作方法
 * <p>
 * 主要包括 添加，删除，获取用户信息等操作
 * </p>
 *
 * @date 2024-11-28
 */
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

    /**
     * 注册用户
     *
     * @param user {@link UserInfo} 用户信息
     * @return {@link UserTokenResult} 返回用户token等信息
     * @throws Exception 异常
     */
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

    /**
     * 获取用户信息
     *
     * @param userId 传入用户id
     * @return {@link UserInfoResult} 用户详细信息
     * @throws Exception 异常
     */
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

    /**
     * 更新用户信息
     *
     * @param user {@link UserInfo} 待更新用户信息，userId必传
     * @return {@link UserTokenResult} 返回信息
     * @throws Exception 异常
     */
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

    /**
     * 将用户踢出 下线
     *
     * @param kickUser {@link KickUser} 传入用户信息
     * @return {@link KickUsersResult} 返回是否成功信息
     * @throws Exception 异常
     */
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

    /**
     * 查询在线状态信息
     *
     * @param userStatus {@link UserStatus} 用户id集合对象
     * @return {@link UserStatusResult} 返回用户状态相关信息
     * @throws Exception 状态
     */
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
