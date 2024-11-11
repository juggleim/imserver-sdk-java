package com.juggle.im.example.group;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.group.GroupModel;
import com.juggle.im.util.RandomUtil;

public class GroupExample {

    private static final String APP_KEY = "test";
    private static final String APP_SECRET = "myn8SP70TXtSZnn7";
    private static final String PREFIX_API = "http://127.0.0.1:8082";


    public GroupExample() {
    }

    public static void main(String[] args) throws Exception {
        JuggleIm sdk = new JuggleIm(APP_KEY, APP_SECRET, PREFIX_API);

//        // create group
//        GroupModel groupModel = new GroupModel();
//        groupModel.setGroupId(RandomUtil.generateRandomString(9));
//        groupModel.setGroupName("蜻蜓队长粉丝群（1）");
//        groupModel.setMemberIds(new String[] {});
//        groupModel.setGroupPortrait("");
//        ResponseResult createGroupResult = sdk.group.create(groupModel);
//        System.out.println("createGroupResult:  " + createGroupResult.toString());

        GroupModel groupDel = new GroupModel();
        groupDel.setGroupId("mi8t76DVu");
        ResponseResult dismiss = sdk.group.dismiss(groupDel);
        System.out.println("dismiss:  " + dismiss.toString());

    }

}
