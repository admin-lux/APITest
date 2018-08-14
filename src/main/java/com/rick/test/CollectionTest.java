package com.rick.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.UUID;

public class CollectionTest {
	static ArrayList<String> arrayList = new ArrayList<>();
	static {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");

	}

	public static void main(String[] args) {
		// subList();
		 iteratorList();
		// linkedHashMap();
		// hashSet();
//		pair();
	}

	public static void pair() {
		for (int x = 0; x < arrayList.size() - 1; x++) {
			for (int y = x + 1; y < arrayList.size(); y++) {
				System.out.println(arrayList.get(x) + "-" + arrayList.get(y));
			}
		}
	}

	public static void hashSet() {
		Set<String> sets = new HashSet<>();
		for (int i = 0; i < 20; i++) {
			sets.add("a");
		}
		sets.forEach(s -> System.out.println(s));

	}

	public static void linkedHashMap() {
		LinkedHashMap<String, String> urls = new LinkedHashMap<>();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				urls.put("a", null);
			else
				urls.put(UUID.randomUUID().toString(), null);
		}
		if (urls.size() > 0) {
			for (Entry<String, String> entry : urls.entrySet()) {
				System.out.println(entry.getKey());
			}
		}

	}

	public static void iteratorList() {
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().contains("a")) {
				iterator.remove();
			}
		}
		subList();
	}

	public static void subList() {
		// arrayList.remove("a");
		arrayList.stream().forEachOrdered(System.out::println);

		// List<String> as = arrayList.subList(5, arrayList.size());
		// System.out.println(as.size());
		// as.stream().forEachOrdered(System.out::println);
	}

}
