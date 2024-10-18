package com.juggle.im;

import com.juggle.im.chatroom.Chatroom;
import com.juggle.im.message.MsgSender;
import com.juggle.im.user.User;

public class JuggleIm {
    private String appkey;
    private String secret;
    private String apiUrl;

    public User user;
    public MsgSender msgSender;
    public Chatroom chatroom;
    public JuggleIm(String appkey, String secret, String apiUrl){
        this.appkey = appkey;
        this.secret = secret;
        this.apiUrl = apiUrl;
        this.user = new User(this);
        this.msgSender = new MsgSender(this);
        this.chatroom = new Chatroom(this);
    }

    public String getAppkey(){
        return this.appkey;
    }

    public String getSecret(){
        return this.secret;
    }

    public String getApiUrl(){
        return this.apiUrl;
    }
}
