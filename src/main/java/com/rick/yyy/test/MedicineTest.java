package com.rick.yyy.test;

import org.junit.Test;

import com.rick.yyy.test.network.RestAPIHttpClient;

public class MedicineTest {
	public static final String LOCAL_HOST_8080 = "http://localhost:8080";
	public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZG1pbiI6IjAiLCJuYW1lIjoicmljayIsInVzZXJpZCI6InJpY2siLCJpc3MiOiJyZXN0YXBpdXNlciIsImF1ZCI6IjA5OGY2YmNkNDYyMWQzNzNjYWRlNGU4MzI2MjdiNGY2IiwiZXhwIjoxNTE3NTU0ODIwLCJuYmYiOjE1MTczODIwMjB9.K9pRiwhKhqUhnUYJZVjjZFzCf4AvkAfdbSfJ4Fvj2gE";

	@Test
	public void login() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/user/login").add("{\"account\":\"rick\",\"pwd\":\"122223\"}").exe("post");
	}

	@Test
	public void logout() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/user/logout").addHeader("token", TOKEN).exe("post");
	}

	@Test
	public void pwdUpdate() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/user/pwd/update").addHeader("token", TOKEN)
				.add("{\"oldPwd\":\"123456\",\"newPwd\":\"123\"}").exe("post");
	}

	@Test
	public void register() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/user/register").add("{\"account\":\"rick-lu\",\"pwd\":\"123456\"}")
				.exe("post");
	}

}
