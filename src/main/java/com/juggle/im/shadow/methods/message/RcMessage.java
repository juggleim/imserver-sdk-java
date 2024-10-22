package com.juggle.im.shadow.methods.message;

import com.juggle.im.JuggleIm;
import com.juggle.im.shadow.methods.message.chatroom.RcChatroom;
import com.juggle.im.shadow.methods.message._private.RcPrivate;

public class RcMessage {
    private JuggleIm juggleim;
    public RcPrivate msgPrivate;
    public RcChatroom msgChatroom;
    public RcMessage(JuggleIm juggleim){
        this.juggleim = juggleim;

        this.msgPrivate = new RcPrivate(this.juggleim);
        this.msgChatroom = new RcChatroom(this.juggleim);
    }

    
}
