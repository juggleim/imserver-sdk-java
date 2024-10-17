package com.juggle.im.chatroom;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomBanMemberIds;
import com.juggle.im.models.chatroom.ChatroomBanMembersResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

public class ChatroomMemberBan {
    private JuggleIm juggleim;
    public ChatroomMemberBan(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public ResponseResult add(ChatroomBanMemberIds banIds)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/chatrooms/banmembers/add";
        String body = GsonUtil.toJson(banIds);
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

    public ResponseResult remove(ChatroomBanMemberIds banIds)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/chatrooms/banmembers/del";
        String body = GsonUtil.toJson(banIds);
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

    public ChatroomBanMembersResult getList(String chatId, int limit, String offset)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+"/apigateway/chatrooms/banmembers/query?chat_id="+URLEncoder.encode(chatId, "UTF-8");
        urlPath = urlPath + "&limit="+limit;
        urlPath = urlPath + "&offset="+offset;
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(),urlPath);
        String response = "";
        ChatroomBanMembersResult result = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (ChatroomBanMembersResult)GsonUtil.fromJson(response, ChatroomBanMembersResult.class);
        }catch(Exception e){
            result = new ChatroomBanMembersResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage(),null);
        }
        return result;
    }
}
