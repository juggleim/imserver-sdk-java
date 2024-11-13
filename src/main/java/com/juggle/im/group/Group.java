package com.juggle.im.group;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.group.*;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class Group {

    private JuggleIm juggleim;

    public Group(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    /**
     * 创建群
     * @param groupAdd
     * @return
     * @throws Exception
     */
    public ResponseResult create(GroupAdd groupAdd) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/add";
        String body = GsonUtil.toJson(groupAdd);
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

    /**
     * 修改群
     * groupUpd.groupId必填
     * @param groupUpd
     * @return
     * @throws Exception
     */
    public ResponseResult update(GroupUpd groupUpd) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/update";
        String body = GsonUtil.toJson(groupUpd);
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

    /**
     * 获取群信息
     * @param groupId
     * @return
     * @throws Exception
     */
    public GroupResult get(String groupId) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/info?group_id=" + URLEncoder.encode(groupId, "UTF-8");
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        String response = "";
        GroupResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (GroupResult) GsonUtil.fromJson(response, GroupResult.class);
        } catch (Exception e) {
            result = new GroupResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    /**
     * 解散群
     * @param groupDel
     * @return
     * @throws Exception
     */
    public ResponseResult dismiss(GroupDel groupDel) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/del";
        String body = GsonUtil.toJson(groupDel);
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
