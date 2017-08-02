package com.rick.yyy.test;

import com.rick.yyy.test.network.RestAPIHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/10/25.
 */
public class LoginTest extends YYYBaseTest {

    @Test
    public void getBillsState0() throws JSONException {
        login();
        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
                .setToken(token)
                .exe("get");
    }

    @Test
    public void getBillsState3() throws JSONException {
        login();
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("statue", "3");
        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
                .setToken(token)
                .add(p)
                .exe("get");
    }

    /**
     * 打款账单列表
     * @throws JSONException
     */
    @Test
    public void getBillsState2() throws JSONException {
        login();
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("statue", "2");
        RestAPIHttpClient.c(yyy_url_host + "/ope/bills")
                .setToken(token)
                .add(p)
                .exe("get");
    }

    @Test
    public void balances() throws JSONException {
        login();
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("ids", new String[]{"64"});
        RestAPIHttpClient.c(yyy_url_host + "/ope/balances")
                .setToken(token)
                .add(p)
                .exe("post");
    }

    @Test
    public void audits() throws JSONException {
        login();
        RestAPIHttpClient.c(yyy_url_host + "/ope/audits/64")
                .setToken(token)
                .exe("post");
    }


    @Test
    public void remittances() throws JSONException {
        login();
        RestAPIHttpClient.c(yyy_url_host + "/ope/remittances/64")
                .setToken(token)
                .exe("post");
    }

    @Test
    public void msglists() throws JSONException {
        login();
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("type", "209");
        RestAPIHttpClient.c(yyy_url_host + "/com/msglists")
                .setToken(token)
                .add(p)
                .exe("get");
    }

    @Test
    public void records() throws JSONException {
        login();
        RestAPIHttpClient.c(yyy_url_host + "/com/accounts/records")
                .setToken(token)
                .exe("get");
    }
    @Test
    public void docDills() throws JSONException {
        login();
        RestAPIHttpClient.c(yyy_url_host + "/doc/bills/64")
                .setToken(token)
                .exe("get");
    }
}
