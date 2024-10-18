package com.juggle.im.shadow.methods.chatroom.block;

import java.util.ArrayList;
import java.util.List;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomMember;
import com.juggle.im.models.chatroom.ChatroomBanMemberIds;
import com.juggle.im.models.chatroom.ChatroomBanMembersResult;

import io.rong.models.chatroom.ChatroomModel;

public class RcBlock {
    private JuggleIm juggleim;

    public RcBlock(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public io.rong.models.response.ResponseResult add(ChatroomModel chatroom)throws Exception{
        List<String> memberIds = new ArrayList<>();
        for(io.rong.models.chatroom.ChatroomMember m : chatroom.getMembers()){
            memberIds.add(m.getId());
        }
        ChatroomBanMemberIds banIds = new ChatroomBanMemberIds(chatroom.getId(), memberIds);
        ResponseResult result = this.juggleim.chatroom.chrmMemberBan.add(banIds);
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
        ChatroomBanMemberIds banIds = new ChatroomBanMemberIds(chatroom.getId(), memberIds);
        ResponseResult result = this.juggleim.chatroom.chrmMemberBan.remove(banIds);
        io.rong.models.response.ResponseResult rcResult;
        if(result!=null){
            rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        }else{
            rcResult = new io.rong.models.response.ResponseResult(500, "can not get data.");
        }
        return rcResult;
    }

    public io.rong.models.response.ListBlockChatroomUserResult getList(String chatroomId)throws Exception{
        ChatroomBanMembersResult result = this.juggleim.chatroom.chrmMemberBan.getList(chatroomId, null, null);
        io.rong.models.response.ListBlockChatroomUserResult rcResult;
        if(result!=null){
            if(result.getChatroomMuteMembers()!=null){
                List<io.rong.models.chatroom.ChatroomMember> members = new ArrayList<>();
                for(ChatroomMember m : result.getChatroomMuteMembers().getMembers()){
                    io.rong.models.chatroom.ChatroomMember member = new io.rong.models.chatroom.ChatroomMember();
                    member.setChatroomId(chatroomId);
                    member.setId(m.getMemberId());
                    members.add(member);
                }
                rcResult = new io.rong.models.response.ListBlockChatroomUserResult(members);
            }else{
                rcResult = new io.rong.models.response.ListBlockChatroomUserResult(result.getCode(), result.getErrorMessage(), null);
            }
        }else{
            rcResult = new io.rong.models.response.ListBlockChatroomUserResult(500, "can not get data", null);
        }
        return rcResult;
    }
}
