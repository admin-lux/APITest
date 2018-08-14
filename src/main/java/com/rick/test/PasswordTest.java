package com.rick.test;

public class PasswordTest {

	public static void main(String[] args) {
		String pwd = "123456";
		String salt = SecureRandomTest.salt();
		String pwd2 = MD5Test.MD5(MD5Test.MD5(pwd) + salt);
		
		System.out.println(String.format("pwd:%s", pwd));
		System.out.println(String.format("salt:%s", salt));
		System.out.println(String.format("encryptPwd:%s", pwd2));
		
		System.out.println(pwd2.equals(MD5Test.MD5(MD5Test.MD5(pwd) + salt)));
		System.out.println(MD5Test.MD5(MD5Test.MD5("123456") + new String(salt)));
	}

}
