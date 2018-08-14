package com.rick.test;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		UUIDTest ut = new UUIDTest();
		for (int i = 0; i < 10; i++) {
			ut.outUUID();
		}
	}

	public void outUUID() {
//		System.out.println(UUID.randomUUID().getLeastSignificantBits());
//		System.out.println(UUID.randomUUID().getLeastSignificantBits());
//		
		System.out.println(UUID.randomUUID().toString().replace("-", ""));

	}
}
