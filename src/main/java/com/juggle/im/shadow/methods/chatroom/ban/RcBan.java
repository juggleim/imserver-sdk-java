package com.juggle.im.shadow.methods.chatroom.ban;

import java.util.ArrayList;
import java.util.List;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomMember;
import com.juggle.im.models.chatroom.ChrmGlobalMuteMemberIds;
import com.juggle.im.models.chatroom.ChrmGlobalMuteMembersResult;

import io.rong.models.chatroom.ChatroomModel;

public class RcBan {
    private JuggleIm juggleim;

    public RcBan(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public io.rong.models.response.ResponseResult add(ChatroomModel chatroom)throws Exception{
        List<String> ids = new ArrayList<>();
        for(io.rong.models.chatroom.ChatroomMember m : chatroom.getMembers()){
            ids.add(m.id);
        }
        ChrmGlobalMuteMemberIds muteIds = new ChrmGlobalMuteMemberIds(ids);
        ResponseResult result = this.juggleim.chatroom.chrmGlobalMute.add(muteIds);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.response.ResponseResult remove(ChatroomModel chatroom)throws Exception{
        List<String> ids = new ArrayList<>();
        for(io.rong.models.chatroom.ChatroomMember m : chatroom.getMembers()){
            ids.add(m.id);
        }
        ChrmGlobalMuteMemberIds muteIds = new ChrmGlobalMuteMemberIds(ids);
        ResponseResult result = this.juggleim.chatroom.chrmGlobalMute.remove(muteIds);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.response.ListGagChatroomUserResult getList()throws Exception{
        ChrmGlobalMuteMembersResult result = this.juggleim.chatroom.chrmGlobalMute.getList(null, null);
        io.rong.models.response.ListGagChatroomUserResult rcResult;
        if(result!=null){
            if(result.getChatroomMuteMembers()!=null){
                List<io.rong.models.chatroom.ChatroomMember> members = new ArrayList<>();
                for(ChatroomMember m : result.getChatroomMuteMembers().getMembers()){
                    io.rong.models.chatroom.ChatroomMember member = new io.rong.models.chatroom.ChatroomMember();
                    member.setChatroomId("");
                    member.setId(m.getMemberId());
                    members.add(member);
                }
                rcResult = new io.rong.models.response.ListGagChatroomUserResult(members);
            }else{
                rcResult = new io.rong.models.response.ListGagChatroomUserResult(result.getCode(), result.getErrorMessage(), null);
            }
        }else{
            rcResult = new io.rong.models.response.ListGagChatroomUserResult(500, "can not get data", null);
        }
        return rcResult;
    }
}
