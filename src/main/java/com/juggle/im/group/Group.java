package com.juggle.im.group;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.group.GroupModel;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;

public class Group {

    private JuggleIm juggleim;

    public Group(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public ResponseResult create(GroupModel groupModel) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/add";
        String body = GsonUtil.toJson(groupModel);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ResponseResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ResponseResult) GsonUtil.fromJson(response, ResponseResult.class);
        } catch (Exception e) {
            result = new ResponseResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage());
        }
        return result;
    }


}
