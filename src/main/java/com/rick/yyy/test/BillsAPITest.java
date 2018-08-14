package com.rick.yyy.test;

import com.rick.yyy.test.network.RestAPIHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.ws.Action;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by MyPC on 2016/10/25.
 */
public class BillsAPITest extends YYYBaseTest {


    @Test
    public void arrayTest(){
        String[] strs = new String[]{"a","c","b"};
        Arrays.sort(strs);
        for (String s:strs) {
            System.out.println(s);
        }
    }


    @Test
    public void testString(){
        System.out.println("1496275200000".substring(0, 13-3));
    }


    @Test
    public void getBillsCreate0() throws JSONException {
        RestAPIHttpClient.c("http://localhost:8081" + "/ope/bills/create")
                .exe("get");
    }

    @Test
    public void getBillsState0() throws JSONException {
        login();
        //sort=&page=1&size=10&storeName=&date=&statue=
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("statue", "0");
        p.put("sort","");
        p.put("page",1);
        p.put("size",10);
        p.put("storeName","91");
        //http://1600f753m5.iok.la/doctest/ope/bills?token=cab55fe079254e5290b4a9f3a8e1d9ca990000000cc6986aa082440ce873200cfd132dc46&sort=&page=1&size=10&storeName=&date=&statue=0
//        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
        RestAPIHttpClient.c("http://localhost:8081/ope/bills")
                .setToken(token)
                .add(p)
                .exe("get");
    }
//
//    @Test
//    public void getBillsState1() throws JSONException {
//        login();
//        HashMap<String, Object> p = new HashMap<String, Object>();
//        p.put("statue", "1");
//        p.put("sort","");
//        p.put("page",1);
//        p.put("size",10);
//        p.put("date","1498838400000");
//        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
//                .setToken(token)
//                .add(p)
//                .exe("get");
//    }
//
//
//
//    @Test
//    public void getBillsState3() throws JSONException {
//        login();
//        HashMap<String, Object> p = new HashMap<String, Object>();
//        p.put("statue", "3");
//        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
//                .setToken(token)
//                .add(p)
//                .exe("get");
//    }
//
//    @Test
//    public void getBillsState4() throws JSONException {
//        login();
//        HashMap<String, Object> p = new HashMap<String, Object>();
//        p.put("statue", "4");
//        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
//                .setToken(token)
//                .add(p)
//                .exe("get");
//    }
//
//    /**
//     * 打款账单列表
//     * @throws JSONException
//     */
//    @Test
//    public void getBillsState2() throws JSONException {
//        login();
//        HashMap<String, Object> p = new HashMap<String, Object>();
//        p.put("statue", "2");
//        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
//                .setToken(token)
//                .add(p)
//                .exe("get");
//    }
//
//    @Test
//    public void balances() throws JSONException {
//        login();
//        HashMap<String, Object> p = new HashMap<String, Object>();
//        p.put("ids", new String[]{"64"});
//        RestAPIHttpClient.c(yyy_url_host + "/ope/balances")
//                .setToken(token)
//                .add(p)
//                .exe("post");
//    }
//
//    @Test
//    public void audits() throws JSONException {
//        login();
//        RestAPIHttpClient.c(yyy_url_host + "/ope/audits/65")
//                .setToken(token)
//                .exe("post");
//    }
//
//
//    @Test
//    public void remittances() throws JSONException {
//        login();
//        RestAPIHttpClient.c(yyy_url_host + "/ope/remittances/65")
//                .setToken(token)
//                .exe("post");
//    }
//
//    @Test
//    public void msglists() throws JSONException {
//        login();
//        HashMap<String, Object> p = new HashMap<String, Object>();
//        p.put("type", "209");
//        RestAPIHttpClient.c(yyy_url_host + "/com/msglists")
//                .setToken(token)
//                .add(p)
//                .exe("get");
//    }
//
//    @Test
//    public void records() throws JSONException {
//        login();
//        RestAPIHttpClient.c(yyy_url_host + "/com/accounts/records")
//                .setToken(token)
//                .exe("get");
//    }
//    @Test
//    public void docDills() throws JSONException {
//        login();
//        RestAPIHttpClient.c(yyy_url_host + "/doc/bills/64")
//                .setToken(token)
//                .exe("get");
//    }
}
