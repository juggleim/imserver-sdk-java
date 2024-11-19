package com.juggle.im.example.group;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.group.*;

public class GroupExample {

    private static final String APP_KEY = "test";
    private static final String APP_SECRET = "myn8SP70TXtSZnn7";
    private static final String PREFIX_API = "http://127.0.0.1:8082";


    public GroupExample() {
    }

    public static void main(String[] args) throws Exception {
        JuggleIm sdk = new JuggleIm(APP_KEY, APP_SECRET, PREFIX_API);

//        // create group
//        GroupAdd groupModel = new GroupAdd();
//        groupModel.setGroupId(RandomUtil.generateRandomString(9));
//        groupModel.setGroupName("蜻蜓队长粉丝群（1）");
//        groupModel.setMemberIds(new String[]{});
//        groupModel.setGroupPortrait("");
//        ResponseResult createGroupResult = sdk.group.create(groupModel);
//        System.out.println("createGroupResult:  " + createGroupResult.toString());
//
//        // update group
//        GroupUpd update = new GroupUpd();
//        update.setGroupId("N5zNVXSAL");
//        update.setGroupName("蛮吉窝窝乡粉丝群（1）");
//        update.setGroupPortrait("https://test.icon.com");
//        ResponseResult updateRes = sdk.group.update(update);
//        System.out.println("updateResult:  " + updateRes.toString());
//
//        // dismiss group
//        GroupDel dismissModel = new GroupDel();
//        dismissModel.setGroupId("mi8t76DVu");
//        ResponseResult dismissRes = sdk.group.dismiss(dismissModel);
//        System.out.println("dismiss:  " + dismissRes.toString());
//
//        // group info
//        GroupResult infoResult = sdk.group.get("N5zNVXSAL");
//        System.out.println("infoResult: " + infoResult.toString());

//        // set group setting
//        GroupSetting setting = new GroupSetting();
//        setting.setGroupId("N5zNVXSAL");
//        Map<String, String> params = new HashMap<>(4);
//        params.put("hide_grp_msg", "1");
//        setting.setSettings(params);
//        ResponseResult settingRes = sdk.group.modifyGroupSettings( setting);
//        System.out.println("settingRes: " + settingRes.toString());

//        // get group setting
//        GroupSettingResult settingResult = sdk.group.getGroupSettings("N5zNVXSAL");
//        System.out.println("groupSettingResult: " + settingResult.toString());

//        GroupMemReq groupMemAdd = new GroupMemReq();
//        groupMemAdd.setGroupId("N5zNVXSAL");
//        groupMemAdd.setMemberIds(new String[] {"JR6Mzj8NJ"});
//        ResponseResult groupMemRes = sdk.group.join(groupMemAdd);
//        System.out.println("joinResult:" + groupMemRes.toString());

//        GroupMemReq quitGroup = new GroupMemReq();
//        quitGroup.setGroupId("N5zNVXSAL");
//        quitGroup.setMemberIds(new String[] {"JR6Mzj8NJ"});
//        ResponseResult quitRes = sdk.group.quit(quitGroup);
//        System.out.println("quitGroupResult:" + quitRes.toString());




    }

}
