package com.juggle.im.chatroom;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomInfo;
import com.juggle.im.models.chatroom.ChatroomInfoResult;
import com.juggle.im.models.chatroom.ChrmMemberIds;
import com.juggle.im.models.chatroom.ChrmMembersExistResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class Chatroom {
    private JuggleIm juggleim;

    public ChatroomMemberBan chrmMemberBan;
    public ChatroomMemberMute chrmMemberMute;
    public ChrmGlobalMemberMute chrmGlobalMute;

    public Chatroom(JuggleIm juggleim) {
        this.juggleim = juggleim;

        this.chrmMemberBan = new ChatroomMemberBan(this.juggleim);
        this.chrmMemberMute = new ChatroomMemberMute(this.juggleim);
        this.chrmGlobalMute = new ChrmGlobalMemberMute(this.juggleim);
    }

    public ResponseResult create(ChatroomInfo chatroom) throws Exception {
        if (chatroom == null) {
            return new ResponseResult(1002, "Paramer 'chatrooms' is required");
        }
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/create";
        String body = GsonUtil.toJson(chatroom);
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

    public ResponseResult destroy(ChatroomInfo chatroom) throws Exception {
        if (chatroom == null) {
            return new ResponseResult(1002, "Paramer 'chatrooms' is required");
        }
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/destroy";
        String body = GsonUtil.toJson(chatroom);
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

    public ChatroomInfoResult get(String chatId, int count, int order) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/info?with_members=true&chat_id=" + URLEncoder.encode(chatId, "UTF-8");
        urlPath = urlPath + "&count=" + count;
        urlPath = urlPath + "&order=" + order;
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        String response = "";
        ChatroomInfoResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ChatroomInfoResult) GsonUtil.fromJson(response, ChatroomInfoResult.class);
        } catch (Exception e) {
            result = new ChatroomInfoResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public ChrmMembersExistResult memberExists(ChrmMemberIds members) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/members/exist";
        String body = GsonUtil.toJson(members);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ChrmMembersExistResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ChrmMembersExistResult) GsonUtil.fromJson(response, ChrmMembersExistResult.class);
        } catch (Exception e) {
            result = new ChrmMembersExistResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

}
