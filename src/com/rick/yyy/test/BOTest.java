package com.rick.yyy.test;

import com.rick.yyy.test.network.RestAPIHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

public class BOTest extends YYYBaseTest {
    public static final String LOCAL_HOST_8080 = "http://localhost:8080";


    @Test
    public void start1() throws JSONException {
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("id", "");
        p.put("question", "最近是否有厄贝沙坦治疗自发性高血压的研究进展");
        p.put("index", 1);
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/Demo2/start")
                .add(p)
                .exe("post");

//        System.out.println(result);

//        目前最牛逼的大蒜素有什么黑幕吗？
//        请问您想查看(“大蒜素”或“他汀类”)相关的何种资讯？

//        最近是否有厄贝沙坦硝苯地平治疗自发性高血压的研究进展
//        请问您想查看“治疗”和“自发性高血压”和“进展”相关的何种资讯？

//        查询一下自发性高血压的文献
//        请问您想查看“自发性高血压”相关的何种资讯？


    }

    @Test
    public void start2() throws JSONException {
        HashMap<String, Object> p = new HashMap<>();
        p.put("id", "");
        p.put("question", "目前最牛逼的大蒜素有什么黑幕吗？");
        p.put("index", 1);
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/Demo2/start")
                .add(p)
                .exe("post");
    }

    @Test
    public void start3() throws JSONException {
        HashMap<String, Object> p = new HashMap<>();
        p.put("id", "");
        p.put("question", "查询一下自发性高血压的文献");
        p.put("index", 1);
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/Demo2/start")
                .add(p)
                .exe("post");
    }


    @Test
    public void start4() throws JSONException {
        HashMap<String, Object> p = new HashMap<>();
        p.put("id", "");
        p.put("question", "高血压患者对于高血压的基本知识知晓率普遍是多少？");
        p.put("index", 1);
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/Demo2/start")
                .add(p)
                .exe("post");
    }



    @Test
    public void start5() throws JSONException {
        HashMap<String, Object> p = new HashMap<>();
        p.put("id", "");
        p.put("question", "城乡居民得高血压的流行趋势，农村得高血压的流行趋势,如何预防");
        p.put("index", 1);
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/Demo2/start")
                .add(p)
                .exe("post");
    }
}
