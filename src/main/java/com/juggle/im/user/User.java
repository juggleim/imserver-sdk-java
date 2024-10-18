package com.juggle.im.user;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.user.UserInfo;
import com.juggle.im.models.user.UserInfoResult;
import com.juggle.im.models.user.UserTokenResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

public class User {
    private JuggleIm juggleim;

    public UserBan userBan;
    public TagUser tagUser;

    public User(JuggleIm juggleim){
        this.juggleim = juggleim;
        this.userBan = new UserBan(this.juggleim);
        this.tagUser = new TagUser(this.juggleim);
    }

    public UserTokenResult register(UserInfo user)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+"/apigateway/users/register";
        String body = GsonUtil.toJson(user);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        UserTokenResult result  = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (UserTokenResult)GsonUtil.fromJson(response, UserTokenResult.class);
        }catch(Exception e){
            result = new UserTokenResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage(),null);
        }
        return result;
    }

    public UserInfoResult get(String userId)throws Exception{
        String urlPath = this.juggleim.getApiUrl()+"/apigateway/users/info?user_id="+URLEncoder.encode(userId, "UTF-8");
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(),urlPath);
        String response = "";
        UserInfoResult result = null;
        try{
            response = HttpUtil.returnResult(conn);
            result = (UserInfoResult)GsonUtil.fromJson(response, UserInfoResult.class);
        }catch(Exception e){
            result = new UserInfoResult(500,"request:"+conn.getURL()+",response:"+response+",Exception:"+e.getMessage(),null);
        }
        return result;
    }
}
