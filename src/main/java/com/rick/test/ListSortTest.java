package com.rick.test;

import java.util.ArrayList;
import java.util.List;

public class ListSortTest {
	static class Student {
		Integer status;
		String name;

		public Student(Integer status, String name) {
			super();
			this.status = status;
			this.name = name;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.add(new Student(1, "a"));
		list.add(new Student(2, "b"));
		list.add(new Student(3, "c"));
		list.add(new Student(4, "d"));
		list.add(new Student(5, "e"));
		list.sort((o1,o2)->{
			if(o1.getStatus() == 2) {
				return -1;
			}
			if(o2.getStatus() == 2) {
				return 1;
			}
			return o1.getStatus().compareTo(o2.getStatus());
		});
		list.stream().forEachOrdered(s->System.out.println(s.getStatus()));
	}

}
