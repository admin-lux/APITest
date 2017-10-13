package com.rick.yyy.test;

import com.rick.yyy.test.network.RestAPIHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

public class BOTest extends YYYBaseTest {
    public static final String LOCAL_HOST_8080 = "http://localhost:8080";

    @Test
    public void start() throws JSONException {
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("id", "1507778599681");
//        目前最牛逼的大蒜素有什么黑幕吗？
//        分词为：大蒜 素有
        p.put("question", "跳过");
        p.put("index", 3);
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/Demo2/start")
                .add(p)
                .exe("post");
//        System.out.println(result);
    }

}
