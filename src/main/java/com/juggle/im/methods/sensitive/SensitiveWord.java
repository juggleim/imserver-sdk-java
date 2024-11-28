package com.juggle.im.methods.sensitive;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.sensitiveword.*;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

/**
 * 类 {@code SensitiveWord } 敏感词相关操作方法
 * <p>
 * 主要包括 添加，删除敏感词，导入文件等操作
 * </p>
 *
 * @date 2024-11-28
 */
public class SensitiveWord {

    private JuggleIm juggleim;

    public SensitiveWord(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    /**
     * 添加敏感词
     *
     * @param addReq {@link SensitiveWordAddReq} 敏感词添加对象
     * @return {@link ResponseResult} 返回成功失败的信息
     * @throws Exception 如果http请求出现异常，则可能抛出exception
     */
    public ResponseResult add(SensitiveWordAddReq addReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/sensitivewords/add";
        String body = GsonUtil.toJson(addReq);
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
     * del敏感词
     *
     * @param delReq {@link SensitiveWordDelReq} 传入待删除对象信息
     * @return {@link ResponseResult} 返回是否成功相关信息
     * @throws Exception 异常
     */
    public ResponseResult del(SensitiveWordDelReq delReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/sensitivewords/del";
        String body = GsonUtil.toJson(delReq);
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
     * 分页获取敏感词数据
     *
     * @param req {@link SensitiveWordReq} 分页相关参数
     * @return {@link SensitiveWordResult} 返回敏感词详情
     * @throws Exception 异常
     */
    public SensitiveWordResult page(SensitiveWordReq req) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(this.juggleim.getApiUrl());
        sb.append("/apigateway/sensitivewords/list");
        sb.append("?page=");
        sb.append(req.getPage());
        sb.append("&size=");
        sb.append(req.getSize());
        if (StringUtils.isNotBlank(req.getWord())) {
            sb.append("&word=");
            sb.append(req.getWord());
        }
        if (req.getWordType() != null) {
            sb.append("&word_type=");
            sb.append(req.getWordType());
        }

        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), sb.toString());
        String response = "";
        SensitiveWordResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (SensitiveWordResult) GsonUtil.fromJson(response, SensitiveWordResult.class);
        } catch (Exception e) {
            result = new SensitiveWordResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage());
        }
        return result;
    }

    /**
     * 以文件上传形式批量导入敏感词
     *
     * @param fileReq {@link SensitiveWordFileReq} 传入文件对象参数
     * @return {@link ResponseResult} 返回码 + 返回信息
     * @throws Exception 如果server服务不可用, http请求失败，则返回exception
     */
    public ResponseResult importFromFile(SensitiveWordFileReq fileReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/sensitivewords/import";
        String boundary = Long.toHexString(System.currentTimeMillis()); // 随机边界
        HttpURLConnection conn = HttpUtil.CreateFilePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath, boundary);
        ResponseResult result = null;
        String response = "";
        OutputStream out = null;
        try {

            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary + ";charset=utf-8");
            out = conn.getOutputStream();
            byte[] entryBoundaryBytes = ("\r\n--" + boundary + "\r\n").getBytes("utf-8");
            out.write(entryBoundaryBytes);
            out.write(getFileEntry(fileReq));
            // data数组现在包含文件的字节数据
            out.write(fileReq.getData());
            out.write(entryBoundaryBytes);

            response = HttpUtil.returnResult(conn);
            result = (ResponseResult) GsonUtil.fromJson(response, ResponseResult.class);
        } catch (Exception e) {
            result = new ResponseResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 内部使用 拼接 http请求 body file 部分格式
     *
     * @param fileReq {@link SensitiveWordFileReq} 文件相关参数对象
     * @return byte[] 返回字符串数组
     * @throws UnsupportedEncodingException
     */
    private static byte[] getFileEntry(SensitiveWordFileReq fileReq) throws UnsupportedEncodingException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data; name=\"");
        entry.append("file");
        entry.append("\"; filename=\"");
        entry.append(fileReq.getFileName());
        entry.append("\"\r\nContent-Type:");
        entry.append("text/plain; charset=utf-8\r\n\r\n");
        entry.append("\r\n\r\n");
        return entry.toString().getBytes("utf-8");
    }

}
