package com.rick.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

public class StringTest {

	public static void main(String[] args) {
		// String s ="20171114184508_0点任务";
		// System.out.println(s.substring(s.indexOf("_")+1));

//		List<Integer> ints = new ArrayList<>();
//		ints.add(5);
//		ints.add(6);
//		ints.add(2);
//		ints.add(1);
//		ints.add(3);
//		ints.add(4);
//		ints.add(9);
//		Collections.sort(ints);
//		System.out.println(ints.toString());
		
		
//		List<String> ss = new ArrayList<>();
//		ss.add("a");
//		ss.add("b");
//		ss.add("c");
//		ss.add("d");
//		StringBuffer sb = new StringBuffer();
//		ss.stream().map(s->{ return s+"</br>";}).forEachOrdered(s->{sb.append(s);});
//		System.out.println(sb.toString());

//		System.out.println("\u914D\u7F6E");
		
		
//		split();
//		System.out.println(".");
		
//		String s = "a-a-a-a-a";
//		System.out.println(s.substring(0, s.length()));
//		
//		code();
		
	}
	
	static String[] codes = new String[] {
			"11-1-1",
			"11-1-2",
			"11-1-3",
			"11-1-4",
			"11-1-5",
			"12-1-1",
			"12-1-2",
			"12-1-3",
			"12-1-4",
			"12-1-5",
			"13-1-1",
			"13-1-2",
			"13-1-4",
			"13-1-5",
			"13-1-6",
			"13-1-7",
			"13-2-1",
			"13-2-2",
			"13-2-3",
			"13-2-4",
			"13-2-5",
			"13-2-6",
			"14-1-1",
			"14-1-2",
			"14-1-3",
			"14-1-4",
			"15-1-1",
			"15-1-2",
			"15-1-3",
			"16-1-1",
			"16-1-2",
			"16-2-1",
			"16-2-2"
	};
	
	static String[] errCodes = new String[] {
			"11-1-2",
			"12-1-2",
			"13-1-2",
			"13-2-6",
			"14-1-4"
	};
	
	
	public static void code() {
		
	}
	
	
	
//	public static void split() {
//		String s = "八珍益母丸.doc";
//		String[] ss = s.split("\\.");
//		Arrays.asList(ss).stream().forEachOrdered(System.out::println);
//	}
	
}
