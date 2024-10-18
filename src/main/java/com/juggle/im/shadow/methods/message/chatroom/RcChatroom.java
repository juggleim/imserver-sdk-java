package com.juggle.im.shadow.methods.message.chatroom;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.message.ChatroomMessage;

public class RcChatroom {
    private JuggleIm juggleim;

    public RcChatroom(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public io.rong.models.response.ResponseResult send(io.rong.models.message.ChatroomMessage message)throws Exception{
        ChatroomMessage msg = new ChatroomMessage();
        msg.setSenderId(message.getSenderId());
        msg.setTargetIds(message.getTargetId());
        msg.setMsgType(message.getContent().getType());
        msg.setMsgContent(message.getContent().toString());
        msg.setPushContent(message.getPushContent());
        msg.setPushExt(message.getPushExt());
        msg.setIsStorage(message.getIsPersisted()>0);
        msg.setIsNotifySender(message.getIsIncludeSender()>0);
        ResponseResult result = this.juggleim.msgSender.sendChatroomMsg(msg);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.response.ResponseResult broadcast(io.rong.models.message.ChatroomMessage message)throws Exception{
        ChatroomMessage msg = new ChatroomMessage();
        msg.setSenderId(message.getSenderId());
        msg.setTargetIds(message.getTargetId());
        msg.setMsgType(message.getContent().getType());
        msg.setMsgContent(message.getContent().toString());
        msg.setPushContent(message.getPushContent());
        msg.setPushExt(message.getPushExt());
        msg.setIsStorage(message.getIsPersisted()>0);
        msg.setIsNotifySender(message.getIsIncludeSender()>0);
        ResponseResult result = this.juggleim.msgSender.sendChatroomMsg(msg);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }
}
