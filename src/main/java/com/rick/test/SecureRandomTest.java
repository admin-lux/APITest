package com.rick.test;

import java.security.SecureRandom;

public class SecureRandomTest {

	public static void main(String[] args) {

		// 安全的随机函数,用于生成salt
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[100];
		random.nextBytes(bytes);

		System.out.println(new String(bytes));
		System.out.println();

		System.out.println(new String(random.generateSeed(100)));
	}
	
	
	public static String salt() {
		SecureRandom random = new SecureRandom();
		return new String(random.generateSeed(100));
	}
	
}
