package com.rick.test;

public class ProvinceTest {
	public static void main(String[] args) {
		// String[] ps =
		// "北京市，天津市，上海市，重庆市，河北省，山西省，辽宁省，吉林省，黑龙江省，江苏省，浙江省，安徽省，福建省，江西省，山东省，河南省，湖北省，湖南省，广东省，海南省，四川省，贵州省，云南省，陕西省，甘肃省，青海省，台湾省"
		// .split("，");
		//
		// StringBuffer sb = new StringBuffer();
		// for (int i = 0; i < ps.length; i++) {
		// String string = ps[i];
		// sb.append(string.substring(0, string.length()-1)).append(",");
		// }
		//
		// System.out.println(sb);

		System.out.println(
				"北京,天津,上海,重庆,河北,山西,辽宁,吉林,黑龙江,江苏,浙江,安徽,福建,江西,山东,河南,湖北,湖南,广东,海南,四川,贵州,云南,陕西,甘肃,青海,台湾,内蒙古,广西,西藏,宁夏,新疆,香港,澳门,中国".split(",").length);
	}
}
