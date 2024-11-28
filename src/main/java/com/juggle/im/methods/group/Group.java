package com.juggle.im.methods.group;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.group.*;
import com.juggle.im.models.group.mute.GroupMemAllowReq;
import com.juggle.im.models.group.mute.GroupMemMuteReq;
import com.juggle.im.models.group.mute.GroupMuteReq;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * 类 {@code Group } 群相关操作方法
 * <p>
 * 主要包括 添加，删除，获取群信息，群成员禁言等群相关操作
 * </p>
 *
 * @date 2024-11-28
 */
public class Group {

    /**
     * 相关配置信息
     */
    private JuggleIm juggleim;

    public Group(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    /**
     * 创建群
     *
     * @param groupAdd {@link GroupAdd} 传入创建群相关参数：群id, 名称，头像
     * @return {@link ResponseResult} 返回是否成功信息
     * @throws Exception 异常
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
     * <p>
     * groupUpd.groupId必填
     * </p>
     *
     * @param groupUpd {@link GroupUpd} 更新群信息
     * @return {@link ResponseResult} 返回是否成功信息
     * @throws Exception 异常
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
     *
     * @param groupId {@link String} 群id
     * @return {@link GroupResult} 返回详细群信息结果
     * @throws Exception 异常
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
     *
     * @param groupDel {@link GroupDel} 传入群id
     * @return {@link ResponseResult} 是否解散成功
     * @throws Exception 异常
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

    /**
     * 修改群配置
     *
     * @param setting {@link GroupSetting} 群配置参数
     * @return {@link ResponseResult} 返回是否成功
     * @throws Exception 异常
     */
    public ResponseResult modifyGroupSettings(GroupSetting setting) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/settings/set";
        String body = GsonUtil.toJson(setting);
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
     * 获取群配置
     *
     * @param groupId {@link String} 传入群id
     * @return {@link GroupSettingResult} 返回群配置信息
     * @throws Exception 异常
     */
    public GroupSettingResult getGroupSettings(String groupId) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/settings/get?group_id=" + URLEncoder.encode(groupId, "UTF-8");
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        String response = "";
        GroupSettingResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (GroupSettingResult) GsonUtil.fromJson(response, GroupSettingResult.class);
        } catch (Exception e) {
            result = new GroupSettingResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    /**
     * 进群
     *
     * @param memberReq {@link GroupMemReq} 传入群id, 群成员id
     * @return {@link ResponseResult} 返回是否进群成功
     * @throws Exception 异常
     */
    public ResponseResult join(GroupMemReq memberReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/members/add";
        String body = GsonUtil.toJson(memberReq);
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
     * 退群
     *
     * @param memReq {@link GroupMemReq} 传入群id, 群成员id
     * @return {@link ResponseResult} 返回是否成功
     * @throws Exception 异常
     */
    public ResponseResult quit(GroupMemReq memReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/members/del";
        String body = GsonUtil.toJson(memReq);
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
     * 群禁言
     * isMute=1 禁言
     *
     * @param muteReq {@link GroupMuteReq} 传入群id, 禁言标识等
     * @return {@link ResponseResult} 返回是否成功
     * @throws Exception 异常
     */
    public ResponseResult groupMute(GroupMuteReq muteReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/groupmute/set";
        String body = GsonUtil.toJson(muteReq);
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
     * 禁言-指定群成员
     * isMute=1 禁言
     *
     * @param memMuteReq {@link GroupMemMuteReq} 传入群id, 群成员id等
     * @return {@link ResponseResult} 返回是否成功信息
     * @throws Exception 异常
     */
    public ResponseResult groupMemMute(GroupMemMuteReq memMuteReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/groupmembermute/set";
        String body = GsonUtil.toJson(memMuteReq);
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
     * allow
     *
     * @param memAllowReq {@link GroupMemAllowReq} 传入群id, 群成员ids等
     * @return {@link ResponseResult} 返回是否成功信息
     * @throws Exception 异常
     */
    public ResponseResult groupMemAllow(GroupMemAllowReq memAllowReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/groups/groupmemberallow/set";
        String body = GsonUtil.toJson(memAllowReq);
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
