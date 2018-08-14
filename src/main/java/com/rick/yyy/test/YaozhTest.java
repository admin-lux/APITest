package com.rick.yyy.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

import com.rick.yyy.test.network.RestAPIHttpClient;

import us.codecraft.webmagic.selector.Html;

public class YaozhTest {
	public static final String LOCAL_HOST_8080 = "http://localhost:8080";
	public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZG1pbiI6IjAiLCJuYW1lIjoicmljayIsInVzZXJpZCI6InJpY2siLCJpc3MiOiJyZXN0YXBpdXNlciIsImF1ZCI6IjA5OGY2YmNkNDYyMWQzNzNjYWRlNGU4MzI2MjdiNGY2IiwiZXhwIjoxNTE3NTU0ODIwLCJuYmYiOjE1MTczODIwMjB9.K9pRiwhKhqUhnUYJZVjjZFzCf4AvkAfdbSfJ4Fvj2gE";

	@Test
	public void login() {
		RestAPIHttpClient.c(LOCAL_HOST_8080 + "/user/login").add("{\"account\":\"rick\",\"pwd\":\"122223\"}")
				.exe("post");
	}

	@Test
	public void instruct() throws Exception {
		File file = new File("E:/aaaa.txt");
		Writer dssWriter = new FileWriter(file);
		for (int i = 0; i < 20; i++) {
			String result = RestAPIHttpClient.c(String.format("https://db.yaozh.com/instruct?p=%s&pageSize=30", i + 1))
					.addHeader("User-Agent",
							"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36")
					.addHeader("cookie",
							"_ga=GA1.2.1315050198.1520215201; MEIQIA_EXTRA_TRACK_ID=0u3L2ePUGfkVdCTQaweSUAquBYT; ad_download=1; _gid=GA1.2.1148378546.1520317152; think_language=zh-CN; _gat=1; yaozh_userId=540444; yaozh_uidhas=1; MEIQIA_EXTRA_TRACK_ID=0u3L2ePUGfkVdCTQaweSUAquBYT; WAF_SESSION_ID=7d88ae0fc48bffa022729657cf09807d; _ga=GA1.3.1315050198.1520215201; yaozh_mylogin=1520388578; Hm_lvt_65968db3ac154c3089d7f9a4cbb98c94=1520215201%2C1520317152,1520388582; WAF_SESSION_ID=7d88ae0fc48bffa022729657cf09807d; PHPSESSID=j9uidv0oln137ndsoefa02fji0; UtzD_f52b_saltkey=TJrqQlTL; UtzD_f52b_lastvisit=1520398132; expire=1520488153457; Hm_lpvt_65968db3ac154c3089d7f9a4cbb98c94=1520403173; yaozh_logintime=1520403174; yaozh_user=540444%09rick_lu; db_w_auth=509180%09rick_lu; UtzD_f52b_ulastactivity=1520317348%7C0; UtzD_f52b_creditnotice=0D0D2D0D0D0D0D0D0D509180; UtzD_f52b_creditbase=0D0D0D0D0D0D0D0D0; UtzD_f52b_creditrule=%E6%AF%8F%E5%A4%A9%E7%99%BB%E5%BD%95; UtzD_f52b_lastact=1520403175%09uc.php%09; UtzD_f52b_auth=0d40olIyrin8XY%2BPoLVpFR%2BMXSjgMpHoCOT5ut6eK1nQk0lBmmwN0UYlY1yn2Aqm8Pf4spzBLyGS5QC5MeUkvnNgzNA")
					.exe();
			
//			Html html = new Html(result);
//			System.out.println(html.xpath(String.format(
//					"//div[@class='offset-top table-list']/table[@class='table table-striped']/tbody/tr[%s]/td[1]/text()",
//					i + 1)).toString());
//			System.out.println(html.xpath(String.format(
//					"//div[@class='offset-top table-list']/table[@class='table table-striped']/tbody/tr[%s]/td[3]/a[@class='cl-blue']/@href",
//					i + 1)).toString());
			
			
			try {
				dssWriter.write(result);
				dssWriter.write("\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dssWriter.flush();
		dssWriter.close();
	}

}
