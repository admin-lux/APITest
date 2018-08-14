package com.rick.yyy.test;

import com.rick.yyy.test.network.RestAPIHttpClient;
import org.junit.Test;

public class BigDataTest {
    public static final String LOCAL_HOST_8080 = "http://localhost:8080";

    public static final String auth = "bearereyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZG1pbiI6IjEiLCJuYW1lIjoiYWRtaW4iLCJ1c2VyaWQiOiIxIiwiaXNzIjoicmVzdGFwaXVzZXIiLCJhdWQiOiIwOThmNmJjZDQ2MjFkMzczY2FkZTRlODMyNjI3YjRmNiIsImV4cCI6MTUxMzUwNTkzMSwibmJmIjoxNTEzMzMzMTMxfQ.hUha7AC4JUKYsoKDtVQmZ1JX7j5eT4NAuarCPGhpc44";


    @Test
    public void addUser() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/addUser")
                .add("{\"name\":\"rick\",\"account\":\"rick\",\"password\":\"123456\"}")
                .exe("post");
    }

    @Test
    public void upUser() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/upUser")
                .add("{\"id\":1,\"name\":\"rick_lu\",\"account\":\"rick\",\"password\":\"123456\"}")
                .exe("post");
    }

    @Test
    public void upUserPwd() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/upUserPwd")
                .add("{\"id\":1,\"name\":\"rick_lu\",\"account\":\"rick\",\"password\":\"654321\"}")
                .exe("post");
    }

    @Test
    public void upUserStatus() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/upUserStatus")
                .add("{\"id\":1,\"name\":\"rick_lu\",\"account\":\"rick\",\"password\":\"654321\",\"status\":0}")
                .exe("post");
    }

    @Test
    public void upUserStatusEq1() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/upUserStatus")
                .add("{\"id\":1,\"name\":\"rick_lu\",\"account\":\"rick\",\"password\":\"654321\",\"status\":1}")
                .exe("post");
    }

    @Test
    public void login() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/login")
                .add("{\"account\":\"admin \",\"password\":\"123\"}")
                .exe("post");
    }

    @Test
    public void selectAll() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/selectAll")
                .add("{\"page\":1,\"size\":5,\"status\":1}")
                .exe("post");
    }

    @Test
    public void selectAllLoginlog() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/loginlog/selectLoginlog")
                .add("{\"page\":1,\"size\":5}")
                .exe("post");
    }

    @Test
    public void addTask() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/tasks/addTask")
                .add("{\"name\":\"0点任务\",\"confName\":\"tables_all_inc.yml\",\"rundate\":\"00:05:00\",\"desc\":\"每日执行\"}")
                .exe("post");
    }

    @Test
    public void upTask() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/tasks/upTask")
                .add("{\"id\":1,\"name\":\"0点任务1111\",\"confName\":\"tables_all_inc.yml\",\"rundate\":\"00:05:00\",\"desc\":\"每日执行\"}")
                .exe("post");
    }

    @Test
    public void deleteTask() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/tasks/deleteTask")
                .add("{\"id\":1}")
                .exe("post");
    }

    @Test
    public void selectTasks() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/tasks/selectTasks")
                .add("{\"page\":1,\"size\":5,\"taskName\":\"0\"}")
                .exe("post");
    }

    @Test
    public void selectTaskAll() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/tasks/selectTaskAll")
                .addAuthorization(auth)
                .exe("post");
    }

    @Test
    public void selectOpes() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/opes/selectOpes")
                .addAuthorization(auth)
                .add("{\"page\":1,\"size\":5,\"account\":\"adm\"}")
                .exe("post");
    }

    @Test
    public void getaudience() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/test/getaudience")
                .exe("get");
    }

    @Test
    public void upUsersStatus() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/users/upUsersStatus")
                .addAuthorization(auth)
                .add("[{\"id\":10,\"status\":1},{\"id\":11,\"status\":1},{\"id\":12,\"status\":1},{\"id\":13,\"status\":1}]")
                .exe("post");
    }

    @Test
    public void addDatasource() {
        for (int i = 0; i < 30; i++) {
            RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/addDatasource")
                    .addAuthorization(auth)
                    .add("{\"sysName\":\"电商主库\",\"databaseName\":\"tkorasol-" + i + "\",\"sourceType\":1,\"userName\":\"hadoopuser\",\"pwd\":\"4CF16DF7D107AF50BF26BE55A35CF96BF123DF97D16AE4B111B37D64\",\"connect\":\"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=lifedb.tkol.taikang.com)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=lifedb2.tkol.taikang.com)(PORT=1521))(LOAD_BALANCE=yes)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=tkorasol)))\"}")
                    .exe("post");
        }
    }

    @Test
    public void upDatasource() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/upDatasource")
                .addAuthorization(auth)
                .add("{\"id\":1,\"sysName\":\"电商主库1111\",\"databaseName\":\"tkorasol\",\"sourceType\":1,\"userName\":\"hadoopuser\",\"pwd\":\"4CF16DF7D107AF50BF26BE55A35CF96BF123DF97D16AE4B111B37D64\",\"connect\":\"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=lifedb.tkol.taikang.com)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=lifedb2.tkol.taikang.com)(PORT=1521))(LOAD_BALANCE=yes)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=tkorasol)))\"}")
                .exe("post");
    }


    @Test
    public void deleteDatasource() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/deleteDatasource")
                .addAuthorization(auth)
                .add("{\"id\":1}")
                .exe("post");
    }

    @Test
    public void deleteDatasources() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/deleteDatasources")
                .addAuthorization(auth)
                .add("[{\"id\":1},{\"id\":2},{\"id\":3}]")
                .exe("post");
    }

    @Test
    public void selectPageDatasources() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/selectPageDatasources")
                .addAuthorization(auth)
                .add("{\"page\":1,\"size\":5,\"sysName\":\"电商\",\"databaseName\":\"tkorasol\",\"sourceType\":0}")
                .exe("post");
    }

    @Test
    public void selectDatasourceAll() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/selectDatasourceAll")
                .addAuthorization(auth)
                .exe("post");
    }

    @Test
    public void testConnect() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/datasources/testConnect")
                .addAuthorization(auth)
                .add("{\"sourceType\":2,\"userName\":\"root\",\"pwd\":\"123456\",\"connect\":\"jdbc:mysql://127.0.0.1/bigdata\"}")
                .exe("post");
    }


    @Test
    public void addImportConf() {
        for(int i =0;i<20;i++){
            RestAPIHttpClient.c(LOCAL_HOST_8080 + "/imports/addImportConf")
                    .addAuthorization(auth)
                    .add(String.format("{\"datasourceId\":4, \"taskId\":2, \"tableName\":\"tkinsure.AL_INSURANT\",\"hbaseName\":\"AL_INSURANT_%s\", \"numMappers\":6, \"columnFamily\":\"info\",\"rowKey\":\"md5(INSURANT_ID)||chr(95)||INSURANT_ID\", \"splitBy\":\"INSURANT_ID\",\"addRowKey\":0,\"importType\":1,\"incrementIf\":\"(CREATE_DATE >= $sysday(-1) and CREATE_DATE < $sysday(0)) or (LAST_UPDATE >= $sysday(-1) and LAST_UPDATE < $sysday(0))\"}", i))
                    .exe("post");
        }
    }

    @Test
    public void upImportConf() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/imports/upImportConf")
                .addAuthorization(auth)
                .add("{\"id\":1,\"datasourceId\":4, \"taskId\":2, \"tableName\":\"tkinsure.AL_INSURANT\",\"hbaseName\":\"AL_INSURANT\", \"numMappers\":6, \"columnFamily\":\"info\",\"rowKey\":\"md5(INSURANT_ID)||chr(95)||INSURANT_ID\", \"splitBy\":\"INSURANT_ID\",\"addRowKey\":0,\"importType\":1,\"incrementIf\":\"(CREATE_DATE >= $sysday(-1) and CREATE_DATE < $sysday(0)) or (LAST_UPDATE >= $sysday(-1) and LAST_UPDATE < $sysday(0))\"}")
                .exe("post");
    }

    @Test
    public void deleteImportConf() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/imports/deleteImportConf")
                .addAuthorization(auth)
                .add("{\"id\":1}")
                .exe("post");
    }

    @Test
    public void deleteImportConfs() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/imports/deleteImportConfs")
                .addAuthorization(auth)
                .add("[{\"id\":3},{\"id\":4},{\"id\":5}]")
                .exe("post");
    }

    @Test
    public void selectPageImports() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/imports/selectPageImports")
                .addAuthorization(auth)
                .add("{\"sysName\":\"电商\",\"databaseName\":\"tkorasol\",\"tableName\":\"AL_INSURANT\",\"taksId\":2,\"page\":1,\"size\":5}")
                .exe("post");
    }
    
    
    @Test
    public void releaseYaml() {
//    	for (int i = 0; i < 10; i++) {
    		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/yaml/releaseYaml")
    		.addAuthorization(auth)
    		.add("{\"id\":1}")
    		.exe("post");
//		}
    }
    
    @Test
    public void downloadYaml() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/yaml/downloadYaml/1")
                .exe("get");
    }
    
    @Test
    public void crYaml() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/yaml/crYaml")
                .addAuthorization(auth)
                .add("{\"type\":1,\"datas\":[{\"id\":2},{\"id\":6},{\"id\":7},{\"id\":8},{\"id\":9},{\"id\":10},{\"id\":11},{\"id\":12},{\"id\":13},{\"id\":14},{\"id\":15},{\"id\":16},{\"id\":17},{\"id\":18},{\"id\":19},{\"id\":20},{\"id\":21},{\"id\":23},{\"id\":24},{\"id\":26}]}")
                .exe("post");
    }
    
    
    @Test
    public void selectMonitors() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/monitor/selectMonitors")
                .addAuthorization(auth)
                .add("{\"taskName\":\"\",\"result\":0}")
                .exe("post");
    }
    

    @Test
    public void selectMonitorDetail() {
        RestAPIHttpClient.c(LOCAL_HOST_8080 + "/monitor/selectMonitorDetail")
                .addAuthorization(auth)
                .add("{\"taskName\":\"20171114184508\"}")
                .exe("post");
    }
    
    @Test
    public void selectSyslog() {
    	RestAPIHttpClient.c(LOCAL_HOST_8080 + "/monitor/selectSyslog")
    	.addAuthorization(auth)
    	.add("{\"taskName\":\"20171114184508\",\"tableName\":\"olbi_tele.BI_MULU_CLUE\"}")
    	.exe("post");
    }
    
    @Test
    public void exportLog() {
    	RestAPIHttpClient.c(LOCAL_HOST_8080 + "/monitor/exportLog/20171114184508")
    	.addAuthorization(auth)
    	.exe("get");
    }
    
    @Test
    public void downloadFailedsYaml() {
    	RestAPIHttpClient.c(LOCAL_HOST_8080 + "/monitor/downloadFailedsYaml/20171130000524")
    	.addAuthorization(auth)
    	.exe("get");
    }
    
    
    
    
}
