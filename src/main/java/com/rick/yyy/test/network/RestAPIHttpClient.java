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

    private static final String CHARSET_UTF_8 = "UTF-8";
    public String url;
    private String token;
    private HashMap<String, Object> params = new HashMap<String, Object>();
    private HashMap<String, Object> headerParams = new HashMap<String, Object>();
    private String paramsJson = "";
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

    public RestAPIHttpClient add(String paramsJson) {
        if (null != paramsJson && paramsJson.length() > 0) {
            this.paramsJson = paramsJson;
        }
        return this;
    }
    public RestAPIHttpClient addAuthorization(String v) {
    	this.addHeader("Authorization", v);
        return this;
    }
    public RestAPIHttpClient addHeader(String key,String value) {
    	this.headerParams.put(key, value);
    	return this;
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

    public String exe() {
    	return exe("get");
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
            System.out.println("Content-type: " + getContentType());

            final HttpURLConnection httpConn = (HttpURLConnection) requestUrl.openConnection();

            httpConn.setConnectTimeout(connectTimeOut);
            httpConn.setReadTimeout(readTimeOut);
            httpConn.setDoInput(true);
            if (isRequestMethod(requestMethod)) {
                httpConn.setDoOutput(true);
                httpConn.setUseCaches(false);
            }
            httpConn.setRequestMethod(requestMethod.toUpperCase());

            httpConn.setRequestProperty("Content-type", getContentType());
            
            if(headerParams.size()>0) {
            	headerParams.forEach((k,v)->{
            		httpConn.setRequestProperty(k,String.valueOf(v));
            	});
            }
                

            httpConn.connect();
            if (isRequestMethod(requestMethod)) {
                OutputStream outStrm = httpConn.getOutputStream();
                outStrm.write(getJsonBody());
                outStrm.flush();
                outStrm.close();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream(), CHARSET_UTF_8));
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
        if (!"".equals(paramsJson)) {
            return paramsJson;
        }
        if (params == null || params.size() == 0)
            return "";
        String suffix = prefix;
        for (String key : params.keySet()) {
            suffix += key + "=" + params.get(key).toString() + "&";
        }
        return suffix.substring(0, suffix.length() - 1);
    }

    private byte[] getJsonBody() throws UnsupportedEncodingException {
        if (!"".equals(paramsJson)) {
            return paramsJson.getBytes(CHARSET_UTF_8);
        }
        if (params == null || params.size() == 0)
            return "".getBytes(CHARSET_UTF_8);
        JSONObject jsonObject = new JSONObject(params);
        String params = jsonObject.toString();
        System.out.println("params: ");
        FormatUtil.printJson(params);
        return params.getBytes(CHARSET_UTF_8);
    }

    private boolean isHttps() {
        return url.toLowerCase().startsWith("https://");
    }

    private String getContentType() {
        if (hasJson) {
            return "application/json; charset=" + CHARSET_UTF_8;
        } else if (hasFile) {
            return "multipart/form-data; boundary=" + mBoundary;
        } else {
            return "application/x-www-form-urlencoded; charset=UTF-8";
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
}