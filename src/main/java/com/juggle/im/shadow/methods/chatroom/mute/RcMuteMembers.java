package com.juggle.im.shadow.methods.chatroom.mute;

import java.util.ArrayList;
import java.util.List;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomMember;
import com.juggle.im.models.chatroom.ChatroomMuteMemberIds;
import com.juggle.im.models.chatroom.ChatroomMuteMembersResult;
import io.rong.models.chatroom.ChatroomModel;

public class RcMuteMembers {
    private JuggleIm juggleim;

    public RcMuteMembers(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public io.rong.models.response.ResponseResult add(ChatroomModel chatroom)throws Exception{
        List<String> memberIds = new ArrayList<>();
        for(io.rong.models.chatroom.ChatroomMember m : chatroom.getMembers()){
            memberIds.add(m.getId());
        }
        ChatroomMuteMemberIds muteIds = new ChatroomMuteMemberIds(chatroom.getId(), memberIds);
        ResponseResult result = this.juggleim.chatroom.chrmMemberMute.add(muteIds);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.response.ResponseResult remove(ChatroomModel chatroom)throws Exception{
        List<String> memberIds = new ArrayList<>();
        for(io.rong.models.chatroom.ChatroomMember m : chatroom.getMembers()){
            memberIds.add(m.getId());
        }
        ChatroomMuteMemberIds muteIds = new ChatroomMuteMemberIds(chatroom.getId(), memberIds);
        ResponseResult result = this.juggleim.chatroom.chrmMemberMute.remove(muteIds);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.response.ListGagChatroomUserResult getList(ChatroomModel chatroom)throws Exception{
        ChatroomMuteMembersResult result = this.juggleim.chatroom.chrmMemberMute.getList(chatroom.getId(), null, null);
        io.rong.models.response.ListGagChatroomUserResult rcResult;
        if(result!=null){
            if(result.getChatroomMuteMembers()!=null){
                List<io.rong.models.chatroom.ChatroomMember> members = new ArrayList<>();
                for(ChatroomMember m : result.getChatroomMuteMembers().getMembers()){
                    io.rong.models.chatroom.ChatroomMember member = new io.rong.models.chatroom.ChatroomMember();
                    member.setChatroomId(chatroom.getId());
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
