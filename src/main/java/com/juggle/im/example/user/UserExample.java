package com.juggle.im.example.user;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.user.*;

public class UserExample {

    private static final String appKey = "test";
    private static final String appSecret = "myn8SP70TXtSZnn7";
    private static final String api = "http://127.0.0.1:8082";

    public UserExample() {
    }

    public static void main(String[] args) throws Exception {
        JuggleIm sdk = new JuggleIm(appKey, appSecret, api);

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

    }


}
