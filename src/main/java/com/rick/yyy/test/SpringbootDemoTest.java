package com.rick.yyy.test;

import org.junit.Test;

import com.rick.yyy.test.network.RestAPIHttpClient;

public class SpringbootDemoTest {
	public static final String LOCAL_HOST_8080 = "http://localhost:8080";

	@Test
	public void findOneCity() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/api/city/1").exe("get");
	}

	@Test
	public void findAllCity() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/api/city").exe("get");
	}

	@Test
	public void createCity() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/api/city")
				.add("{\"id\":2,\"provinceId\":\"3\",\"cityName\":\"三亚\",\"description\":\"水好\"}").exe("post");
	}

	@Test
	public void modifyCity() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/api/city")
				.add("{\"id\":2,\"provinceId\":\"3\",\"cityName\":\"三亚\",\"description\":\"水好，天蓝\"}").exe("put");
	}

	@Test
	public void deleteCity() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/api/city/2").exe("delete");
	}

	@Test
	public void getToken() {
		RestAPIHttpClient.c("http://localhost:8080/token/getToken").exe("get");
	}

	@Test
	public void verifyToken() {
		RestAPIHttpClient.c("http://localhost:8080/token/verifyToken").addAuthorization(
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZG1pbiI6IjEiLCJuYW1lIjoiYWRtaW4iLCJ1c2VyaWQiOiI4MDAwMDAwMDAwMDAwMSIsImlzcyI6InJlc3RhcGl1c2VyIiwiYXVkIjoiMDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjYiLCJleHAiOjE1MTYxMDY2NzUsIm5iZiI6MTUxNjA4OTM5NX0.kDjZ68MZ4Xpx72x-Ns8FnKY-nbTgjYqwOhupouW3mtc")
				.exe("get");
	}

	@Test
	public void register() {
		RestAPIHttpClient.c("http://localhost:8080/api/register?pwd=aaaaaa").exe("get");
	}

}
