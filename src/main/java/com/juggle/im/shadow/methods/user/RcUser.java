package com.juggle.im.shadow.methods.user;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.user.UserInfo;
import com.juggle.im.models.user.UserInfoResult;
import com.juggle.im.models.user.UserToken;
import com.juggle.im.models.user.UserTokenResult;
import com.juggle.im.shadow.methods.chatroom.block.RcBlock;
import com.juggle.im.shadow.util.DateUtil;

import io.rong.models.response.TokenResult;
import io.rong.models.response.UserResult;
import io.rong.models.user.UserModel;

public class RcUser {
    private JuggleIm juggleim;
    public RcTag tag;
    public RcBlock block;
    public RcUser(JuggleIm juggleim){
        this.juggleim = juggleim;
        this.tag = new RcTag(this.juggleim);
        this.block = new RcBlock(this.juggleim);
    }

    public TokenResult register(UserModel rcUser)throws Exception{
        UserInfo user = new UserInfo();
        user.setUserId(rcUser.id);
        user.setNickname(rcUser.name);
        user.setUserPortrait(rcUser.portrait);
        UserTokenResult result = this.juggleim.user.register(user);
        TokenResult rcResult = null;
        if(result!=null){
            if(result.getUserToken()==null){
                result.setUserToken(new UserToken("", ""));
            }
            rcResult = new TokenResult(result.getCode(), result.getUserToken().getToken(), result.getUserToken().getUserId(), result.getErrorMessage());
        }else{
            rcResult = new TokenResult(500, null, null, "can not get token");
        }
        return rcResult;
    }

    public UserResult get(UserModel rcUser)throws Exception{
        UserInfoResult result = this.juggleim.user.get(rcUser.id);
        UserResult rcResult = null;
        if(result!=null){
            if(result.getUserInfo()!=null){
                rcResult = new UserResult(result.getUserInfo().getNickname(), result.getUserInfo().getUserPortrait(), DateUtil.formatTime(result.getUserInfo().getUpdatedTime()), result.getErrorMessage());
            }else{
                rcResult = new UserResult(null,null,null, result.getErrorMessage());
            }
        }else{
            rcResult = new UserResult(null, null, null, "no user info.");
        }
        return rcResult;
    }
}
