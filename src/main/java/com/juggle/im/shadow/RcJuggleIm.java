package com.juggle.im.shadow;

import com.juggle.im.JuggleIm;
import com.juggle.im.shadow.methods.chatroom.RcChatroom;
import com.juggle.im.shadow.methods.user.RcUser;

public class RcJuggleIm {
    public JuggleIm juggleim;

    public RcUser user;
    public RcChatroom chatroom;
    public RcJuggleIm(String appkey, String appSecret, String apiUrl){
        this.juggleim = new JuggleIm(appkey, appSecret, apiUrl);
        this.user = new RcUser(this.juggleim);
        this.chatroom = new RcChatroom(this.juggleim);
    }
}
