package com.juggle.im.chatroom;

import java.net.HttpURLConnection;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChrmGlobalMuteMemberIds;
import com.juggle.im.models.chatroom.ChrmGlobalMuteMembersResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

public class ChrmGlobalMemberMute {
    private JuggleIm juggleim;
    public ChrmGlobalMemberMute(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public ResponseResult add(ChrmGlobalMuteMemberIds muteIds)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/chatrooms/globalmutemembers/add";
        String body = GsonUtil.toJson(muteIds);
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

    public ResponseResult remove(ChrmGlobalMuteMemberIds muteIds)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/chatrooms/globalmutemembers/del";
        String body = GsonUtil.toJson(muteIds);
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

    public ChrmGlobalMuteMembersResult getList(String chatId, int limit, String offset)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+"/apigateway/chatrooms/globalmutemembers/query?";
        urlPath = urlPath + "&limit="+limit;
        urlPath = urlPath + "&offset="+offset;
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(),urlPath);
        String response = "";
        ChrmGlobalMuteMembersResult result = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (ChrmGlobalMuteMembersResult)GsonUtil.fromJson(response, ChrmGlobalMuteMembersResult.class);
        }catch(Exception e){
            result = new ChrmGlobalMuteMembersResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage(),null);
        }
        return result;
    }
}
