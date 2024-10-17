package com.juggle.im;

import com.juggle.im.user.User;

public class JuggleIm {
    private String appkey;
    private String secret;
    private String apiUrl;

    public User user;
    public JuggleIm(String appkey, String secret, String apiUrl){
        this.appkey = appkey;
        this.secret = secret;
        this.apiUrl = apiUrl;
        this.user = new User(this);
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
