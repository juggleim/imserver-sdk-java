package com.juggle.im.user;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.user.UserTags;
import com.juggle.im.models.user.UserTagsResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

public class TagUser {
    private JuggleIm juggleim;
    public TagUser(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public ResponseResult add(UserTags userTags)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/usertags/add";
        String body = GsonUtil.toJson(userTags);
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

    public ResponseResult remove(UserTags userTags)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/usertags/del";
        String body = GsonUtil.toJson(userTags);
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

    public ResponseResult clear(String[] userIds)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+ "/apigateway/usertags/clear";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_ids", userIds);
        String body = GsonUtil.toJson(map);
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

    public UserTagsResult qryUserTags(String[] userIds)throws Exception{
        if(userIds.length<=0){
            return new UserTagsResult(1002, "Paramer 'user_id' is required",null);
        }
        String urlPath = this.juggleim.getApiUrl()+"/apigateway/usertags/query?";
        for(int i=0;i<userIds.length;i++){
            if(i==userIds.length-1){
                urlPath = urlPath + "user_id="+userIds[i];
            }else{
                urlPath = urlPath + "user_id="+userIds[i]+"&";
            }
        }
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(),urlPath);
        String response = "";
        UserTagsResult result = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (UserTagsResult)GsonUtil.fromJson(response, UserTagsResult.class);
        }catch(Exception e){
            result = new UserTagsResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage(),null);
        }
        return result;
    }
}
