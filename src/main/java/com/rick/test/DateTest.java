package com.rick.test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	public static void main(String[] args) {
		// DateTest dt = new DateTest();
		//// dt.localDateFormat();
		// dt.plusDays();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(new Date(1510577791057L)));
	}

	public void localDateFormat() {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSS")));
	}

	public void plusDays() {
		// 1510656309077
		Date date = new Date(1510656309077L);
		LocalDate ld = new Date(1510656309077L).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDateTime ldt = new Date(1510656309077L).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(date);
		System.out.println(ld);
		System.out.println(ld.plusDays(1));
		System.out.println(ldt);
		System.out.println(ldt.plusDays(1));
	}

	@Test
	public void timestamp() {
		System.out.println(Instant.now().toEpochMilli() + "\n" + new Date().getTime());
	}

}
