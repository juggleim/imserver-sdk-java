package com.juggle.im.shadow.methods.user.block;

import java.util.ArrayList;
import java.util.List;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.user.BanUsers;
import com.juggle.im.models.user.BanUsersResult;
import com.juggle.im.shadow.util.DateUtil;
import com.juggle.im.models.user.BanUser;

import io.rong.models.user.UserModel;
import io.rong.models.BlockUsers;
import io.rong.models.Result;

public class RcBlock {
    private JuggleIm juggleim;

    public RcBlock(JuggleIm juggleim){
        this.juggleim = juggleim;
    }

    public Result add(UserModel rcUser)throws Exception{
        BanUsers banUsers = new BanUsers();
        List<BanUser> users = new ArrayList<BanUser>();
        BanUser banUser = new BanUser();
        banUser.setUserId(rcUser.id);
        banUser.setEndTime(System.currentTimeMillis()+(rcUser.getMinute()*60*1000));
        users.add(banUser);
        ResponseResult result = this.juggleim.user.userBan.add(banUsers);
        io.rong.models.response.ResponseResult rcResult = new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
        return rcResult;
    }

    public io.rong.models.response.ResponseResult remove(String userId)throws Exception{
        BanUsers banUsers = new BanUsers();
        List<BanUser> users = new ArrayList<BanUser>();
        BanUser banUser = new BanUser();
        banUser.setUserId(userId);
        users.add(banUser);
        ResponseResult result = this.juggleim.user.userBan.remove(banUsers);
        return new io.rong.models.response.ResponseResult(result.getCode(), result.getErrorMessage());
    }

    public Result getList()throws Exception{
        return this.getList(null, null);
    }

    public Result getList(Integer size, Integer page)throws Exception{
        BanUsersResult result = this.juggleim.user.userBan.getList(size, page);
        Result rcResult;
        if(result!=null){
            if(result.getBanUsers()!=null){
                List<io.rong.models.BlockUsers> banUsers = new ArrayList<>();
                if(result.getBanUsers().getItems()!=null){
                    for(BanUser user : result.getBanUsers().getItems()){
                        banUsers.add(new BlockUsers(user.getUserId(), DateUtil.formatTime(user.getEndTime())));
                    }
                }
                rcResult = new io.rong.models.response.BlockUserResult(result.getCode(), result.getErrorMessage(), banUsers);
            }else{
                rcResult = new io.rong.models.response.BlockUserResult(result.getCode(), result.getErrorMessage(), null);
            }
        }else{
            rcResult = new io.rong.models.response.BlockUserResult(500, "can not get data.",null);
        }
        return rcResult;
    }
}
