package com.rick.yyy.test.network;

import com.rick.yyy.test.utils.FormatUtil;
import org.json.JSONObject;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.UUID;


public class RestAPIHttpClient {

    private static final String CHARSET = "UTF-8";
    public String url;
    private String token;
    private HashMap<String, Object> params = new HashMap<String, Object>();
    private boolean hasFile = false;
    private boolean hasJson = true;
    private String mBoundary;
    private int connectTimeOut = 3000000;
    private int readTimeOut = 3000000;

    private RestAPIHttpClient() {
        mBoundary = UUID.randomUUID().toString();
    }

    public static RestAPIHttpClient c(String url) {
        RestAPIHttpClient client = new RestAPIHttpClient();
        client.url = url;
        return client;
    }

    public RestAPIHttpClient add(String k, Object v) {
        params.put(k, v);
        return this;
    }

    public RestAPIHttpClient add(HashMap value) {
        params.putAll(value);
        return this;
    }

    public RestAPIHttpClient setToken(String token) {
        this.token = token;
        return this;
    }

    private void initHTTPSClient() throws NoSuchAlgorithmException,
            KeyManagementException {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new MyX509TrustManager()},
                    new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection
                    .setDefaultHostnameVerifier(new MyHostnameVerifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MyHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
//		if("localhost".equals(hostname)){
//			return true;
//		} else {
//			return false;
//		}
            return true;
        }
    }


    class MyX509TrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
            System.out.println("cert: " + chain[0].toString() + ", authType: "
                    + authType);
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public String exe(String requestMethod) {
        System.out.println();
        System.err.println("-------------------------------");
        System.out.println();
        try {
            if (isHttps()) {
                initHTTPSClient();
            }

            URL requestUrl;

            if (!isRequestMethod(requestMethod)) {
                // GET,delete
                if (null == token || "".equals(token)) {
                    requestUrl = new URL(url + getKVValues("?"));
                } else {
                    requestUrl = new URL(url + "?token=" + token + getKVValues("&"));
                }
            } else {
                // POST,put
                if (null == token || "".equals(token)) {
                    requestUrl = new URL(url);
                } else {
                    requestUrl = new URL(url + "?token=" + token);
                }
            }
            System.out.println("URL: " + requestUrl.toString());

            HttpURLConnection httpConn = null;
            httpConn = (HttpURLConnection) requestUrl.openConnection();

            httpConn.setConnectTimeout(connectTimeOut);
            httpConn.setReadTimeout(readTimeOut);
            httpConn.setDoInput(true);
            if (isRequestMethod(requestMethod)) {
                httpConn.setDoOutput(true);
                httpConn.setUseCaches(false);
            }
            httpConn.setRequestMethod(requestMethod.toUpperCase());

            httpConn.setRequestProperty("Content-type", getContentType());

            httpConn.connect();
            if (isRequestMethod(requestMethod)) {
                OutputStream outStrm = httpConn.getOutputStream();
                outStrm.write(getJsonBody());
                outStrm.flush();
                outStrm.close();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream(), CHARSET));
            System.out.println("httpCode: " + httpConn.getResponseCode());
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            //JSON 格式化输出
            FormatUtil.printJson(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isRequestMethod(String requestMethod) {
        return "post".equals(requestMethod.toLowerCase()) || "put".equals(requestMethod.toLowerCase());
    }

    private String getKVValues(String prefix) {
        if (params == null || params.size() == 0)
            return "";
        String suffix = prefix;
        for (String key : params.keySet()) {
            suffix += key + "=" + params.get(key).toString() + "&";
        }
        return suffix.substring(0, suffix.length() - 1);
    }

    private byte[] getJsonBody() throws UnsupportedEncodingException {
        if (params == null || params.size() == 0)
            return "".getBytes(CHARSET);
        JSONObject jsonObject = new JSONObject(params);
        String params = jsonObject.toString();
        System.out.println("params: " + params);
        return params.getBytes(CHARSET);
    }

    private boolean isHttps() {
        return url.toLowerCase().startsWith("https://");
    }

    private String getContentType() {
        if (hasJson) {
            return "application/json; charset=" + CHARSET;
        } else if (hasFile) {
            return "multipart/form-data; boundary=" + mBoundary;
        } else {
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }
    }
}