package com.rick.test;

import cn.hutool.core.util.ReUtil;

public class RegularTest {
	
	public static void main(String[] args) {
		RegularTest test = new RegularTest();
		test.get();
		
		
	}
	
	
	
	public void get() {
		String original = "[药品名称]\r\n" + 
				"通用名称:丹参口服液\r\n" + 
				"汉语拼音:DanshenKoufuye\r\n" + 
				"[成份]\r\n" + 
				"丹参.\r\n" + 
				"[性状]\r\n" + 
				"本品为棕色液体,味甜微涩.\r\n" + 
				"[功能主治]\r\n" + 
				"活血化淤、养心通脉.用于胸痹引起的心痛,心悸,胸闷,乏力以及轻度冠心病胸闷,心绞痛等症.\r\n" + 
				"[规格]\r\n" + 
				"10ml\r\n" + 
				"[用法用量]\r\n" + 
				"口服,一次10ml,一日2次.\r\n" + 
				"[不良反应]\r\n" + 
				"尚不明确.\r\n" + 
				"[禁忌]\r\n" + 
				"对本品过敏者禁用.\r\n" + 
				"[注意事项]\r\n" + 
				"1.孕妇及过敏体质者慎用.\r\n" + 
				"2.忌食生冷、辛辣、油腻之物.\r\n" + 
				"3.药品性状发生改变时禁止使用.\r\n" + 
				"4.请将此药品放在儿童不能接触的地方.\r\n" + 
				"[孕妇及哺乳期妇女用药]\r\n" + 
				"慎用.\r\n" + 
				"[贮藏]\r\n" + 
				"遮光,密闭保存.\r\n" + 
				"[包装]\r\n" + 
				"棕色玻璃管制口服液体瓶装,10ml/瓶,10瓶/盒.\r\n" + 
				"[有效期]\r\n" + 
				"24个月.(截止期见药盒)\r\n" + 
				"[执行标准]\r\n" + 
				"《中华人民共和国卫生部部标准》WS-73(Z-12)90\r\n" + 
				"[批准文号]\r\n" + 
				"国药准字Z10900036\r\n" + 
				"[生产企业]\r\n" + 
				"企业名称:上海通用药业股份有限公司\r\n" + 
				"生产地址:上海市申南路889号\r\n" + 
				"邮政编码:201108\r\n" + 
				"电话号码:021-64890724\r\n" + 
				"传真号码:021-64894182";
		String enterpriseName = ReUtil.get("企业名称:((.*)((\\r)?\\n))?", original, 2);
//		System.out.println(enterpriseName);
		original = original.substring(original.indexOf("企业名称:")+5, original.length());
		original = original.substring(0, original.indexOf("\r\n"));
		System.out.println(original);
		
	}

}
