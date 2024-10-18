package com.juggle.im.shadow.methods.message._private;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.message.PrivateMessage;

public class RcPrivate {
    private JuggleIm juggleim;

    public RcPrivate(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public io.rong.models.response.ResponseResult send(io.rong.models.message.PrivateMessage message)throws Exception{
        PrivateMessage msg = new PrivateMessage();
        msg.setSenderId(message.getSenderId());
        msg.setTargetIds(message.getTargetId());
        msg.setMsgType(message.getContent().getType());
        msg.setMsgContent(message.getContent().toString());
        msg.setPushContent(message.getPushContent());
        msg.setPushExt(message.getPushExt());
        msg.setIsStorage(message.getIsPersisted()>0);
        msg.setIsCount(message.getIsCounted()>0);
        msg.setIsNotifySender(message.getIsIncludeSender()>0);
        ResponseResult result = this.juggleim.msgSender.sendPrivateMsg(msg);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }
}
