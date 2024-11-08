package com.juggle.im.message;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.message.ChatroomMessage;
import com.juggle.im.models.message.PrivateMessage;
import com.juggle.im.models.message.RecallMessage;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;

public class MsgSender {
    private JuggleIm juggleim;

    public MsgSender(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public ResponseResult sendPrivateMsg(PrivateMessage message) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/messages/private/send";
        String body = GsonUtil.toJson(message);
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

    public ResponseResult sendChatroomMsg(ChatroomMessage message) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/messages/chatroom/send";
        String body = GsonUtil.toJson(message);
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

    public ResponseResult broadcastChatroomMsg(ChatroomMessage message) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/messages/chatroom/broadcast";
        String body = GsonUtil.toJson(message);
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

    public ResponseResult recallMsg(RecallMessage msg) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/hismsgs/recall";
        String body = GsonUtil.toJson(msg);
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



}
