package com.juggle.im.example.user;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.user.*;

public class UserExample {

    private static final String APP_KEY = "test";
    private static final String APP_SECRET = "myn8SP70TXtSZnn7";
    private static final String PREFIX_API = "http://127.0.0.1:8082";

    public UserExample() {
    }

    public static void main(String[] args) throws Exception {
        JuggleIm sdk = new JuggleIm(APP_KEY, APP_SECRET, PREFIX_API);

        // register
        UserInfo userInfo = new UserInfo()
                .setUserId("testuser-01")
                .setNickname("铁甲小宝")
                .setUserPortrait("https://file.lwoowl.cn/avatar_jgd/55e321a8-645a-47ae-99ae-284a70086b95.png");
        UserTokenResult register = sdk.user.register(userInfo);
        System.out.println("getToken:  " + register.toString());

        // update
        userInfo.setNickname("铁甲小宝2");
        userInfo.setUserPortrait("https://file.lwoowl.cn/avatar_jgd/55e321a8-645a-47ae-99ae-284a70086b95.png2");
        UserTokenResult update = sdk.user.update(userInfo);
        System.out.println("updateUser:  " + update.toString());

        // 获取用户信息
        UserInfoResult infoResult = sdk.user.get("testuser-01");
        System.out.println("info: " + infoResult.toString());

        // kick user
        KickUser kickUser = new KickUser().setUserId("ImgEatRGU")
                .setPlatforms(new String[]{"PC", "WEB"})
                .setDeviceIds(new String[]{""})
                .setExt("");
        KickUsersResult kickResult = sdk.user.kick(kickUser);
        System.out.println("kickResult: " + kickResult.toString());

        // query user status
        UserStatus query = new UserStatus();
        query.setUserIds(new String[]{"testuser-01", "ImgEatRGU"});
        UserStatusResult userStatusResult = sdk.user.qryOnlineStatusByUserIds(query);
        System.out.println("userStatusResult: " + userStatusResult.toString());

//        // block users
        BlockUsers blockUsers = new BlockUsers();
        blockUsers.setUserId("testuser-01");
        blockUsers.setBlockUserIds(new String[]{"ImgEatRGU"});
        ResponseResult blockResult = sdk.user.userBlock.block(blockUsers);
        System.out.println("blockResult: " + blockResult.toString());

        // unblock users
        BlockUsers unblock = new BlockUsers();
        unblock.setUserId("testuser-01");
        unblock.setBlockUserIds(new String[]{"ImgEatRGU"});
        ResponseResult unblockResult = sdk.user.userBlock.unblock(unblock);
        System.out.println("unblockResult: " + unblockResult.toString());

        // query my block users
        BlockUserQry blockUserQry = new BlockUserQry();
        blockUserQry.setUserId("testuser-01");
        blockUserQry.setLimit(10);
        blockUserQry.setOffset(1);
        BlockUsersResult blockUserResult = sdk.user.userBlock.qryBlockUsers(blockUserQry);
        System.out.println("blockResult: " + blockUserResult.toString());


    }


}
