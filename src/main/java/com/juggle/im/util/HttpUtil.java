package com.juggle.im.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.UUID;
import com.juggle.im.models.ResponseResult;

public class HttpUtil {
    private static final String APPKEY = "appkey";
    private static final String NONCE = "nonce";
    private static final String TIMESTAMP = "timestamp";
    private static final String SIGNATURE = "signature";
    private static SSLContext sslCtx = null;

    static {
        try {
            sslCtx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sslCtx.init(null, new TrustManager[]{tm}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                // TODO Auto-generated method stub
                return true;
            }

        });

        HttpsURLConnection.setDefaultSSLSocketFactory(sslCtx.getSocketFactory());

    }

    public static HttpURLConnection CreateGetHttpConnection(String appKey, String appSecret,String uri) throws MalformedURLException, IOException {
        String nonce = String.valueOf(Math.random() * 1000000);// SecureRandom random = new SecureRandom(); random.nextInt(1000000);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        StringBuilder toSign = new StringBuilder(appSecret).append(nonce).append(timestamp);
        String sign = Util.Sha1(toSign.toString());
        
        HttpURLConnection conn = getHttpURLConnection(uri);

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setInstanceFollowRedirects(true);
        conn.setRequestProperty(APPKEY, appKey);
        conn.setRequestProperty(NONCE, nonce);
        conn.setRequestProperty(TIMESTAMP, timestamp);
        conn.setRequestProperty(SIGNATURE, sign);
        conn.setRequestProperty("Content-Type", "application/json");

        return conn;
    }

    // 设置body体
    public static void setBodyParameter(String body, HttpURLConnection conn) throws IOException {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(conn.getOutputStream());
            out.write(body.getBytes("utf-8"));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (null != out) {
                out.close();
            }
        }
    }

    public static HttpURLConnection CreatePostHttpConnection(String appKey, String appSecret,
                                                             String uri) throws MalformedURLException, IOException, ProtocolException {
        return CreatePostHttpConnection( appKey, appSecret, uri, "application/json");
    }

    public static HttpURLConnection CreatePostHttpConnection( String appKey, String appSecret,
                                                             String uri,
                                                             String contentType) throws MalformedURLException, IOException, ProtocolException {
        String nonce = String.valueOf(Math.random() * 1000000);// SecureRandom random = new SecureRandom(); random.nextInt(1000000);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        StringBuilder toSign = new StringBuilder(appSecret).append(nonce).append(timestamp);
        String sign = Util.Sha1(toSign.toString());
        HttpURLConnection conn = getHttpURLConnection(uri);
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setInstanceFollowRedirects(true);

        conn.setRequestProperty(APPKEY, appKey);
        conn.setRequestProperty(NONCE, nonce);
        conn.setRequestProperty(TIMESTAMP, timestamp);
        conn.setRequestProperty(SIGNATURE, sign);
        conn.setRequestProperty("Content-Type", contentType);
        conn.setRequestProperty("X-Request-ID", UUID.randomUUID().toString().replaceAll("\\-", ""));

        return conn;
    }

    public static HttpURLConnection getHttpURLConnection(String uri)
            throws IOException {
        URL url = new URL(uri);
        return (HttpURLConnection) url.openConnection();
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int buffer_size = 1024;
        byte[] buffer = new byte[buffer_size];
        int len = 0;
        while ((len = inStream.read(buffer, 0, buffer_size)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }

    public static String returnResult(HttpURLConnection conn) throws Exception {
        InputStream input = null;
        String result = "";
        try {
            if (conn.getResponseCode() == 200) {
                input = conn.getInputStream();
            } else {
                input = conn.getErrorStream();
            }
            result = new String(readInputStream(input), "UTF-8");
        } catch (UnknownHostException e) {
            result = getExceptionMessage("request:" + conn.getURL() + " ,x_request_id:" + conn.getRequestProperty("x_request_id") + " ,UnknownHostException:" + e.getMessage());
        } catch (SocketTimeoutException e) {
            result = getExceptionMessage("request:" + conn.getURL() + " ,x_request_id:" + conn.getRequestProperty("x_request_id") + " ,SocketTimeoutException:" + e.getMessage());
        } catch (IOException e) {
            result = getExceptionMessage("request:" + conn.getURL() + " ,x_request_id:" + conn.getRequestProperty("x_request_id") + " ,IOException:" + e.getMessage());
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    private static String getExceptionMessage(String error) {
        return GsonUtil.toJson(new ResponseResult(400, error), ResponseResult.class);
    }

}
