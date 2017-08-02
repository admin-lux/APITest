package com.rick.yyy.test;

import com.rick.yyy.test.network.RestAPIHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

public class YYYBaseTest {
    public String yyy_url_host = "http://192.168.199.162:8081";

    public String token;

    @Test
    public void login() throws JSONException {
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("phone", "15735929578");
        p.put("pwd", "zm123456");
        String result = RestAPIHttpClient.c(yyy_url_host + "/doc/session")
                .add(p)
                .exe("post");
        JSONObject jsonObject = new JSONObject(result);
        token = jsonObject.getString("token");
    }

}
