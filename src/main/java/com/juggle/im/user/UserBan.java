package com.juggle.im.user;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomBanMemberIds;
import com.juggle.im.models.chatroom.ChatroomBanMembersResult;
import com.juggle.im.models.user.BanUsers;
import com.juggle.im.models.user.BanUsersResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

public class UserBan {
    private JuggleIm juggleim;
    public UserBan(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public ResponseResult add(BanUsers banUsers)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/users/banusers/ban";
        String body = GsonUtil.toJson(banUsers);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ResponseResult result  = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (ResponseResult)GsonUtil.fromJson(response, ResponseResult.class);
        }catch(Exception e){
            result = new ResponseResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage());
        }
        return result;
    }

    public ResponseResult remove(BanUsers banUsers)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/users/banusers/unban";
        String body = GsonUtil.toJson(banUsers);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ResponseResult result  = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (ResponseResult)GsonUtil.fromJson(response, ResponseResult.class);
        }catch(Exception e){
            result = new ResponseResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage());
        }
        return result;
    }

    public BanUsersResult getList(String chatId, int limit, String offset)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+"/apigateway/users/banusers/query?";
        urlPath = urlPath + "limit="+limit;
        urlPath = urlPath + "&offset="+offset;
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(),urlPath);
        String response = "";
        BanUsersResult result = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (BanUsersResult)GsonUtil.fromJson(response, BanUsersResult.class);
        }catch(Exception e){
            result = new BanUsersResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage(),null);
        }
        return result;
    }
}
