package com.rick.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * @author rick_lu
 *
 */
public class ParserSyslog {
	private static HashMap<String, String> a = new HashMap<>();
	private String abstractPaths;
	private int type;
	private String indexDate;

	static {
		a.put("tkcx_ANALYZER.PROPERTY_CUSTOMER", "0点任务");
		a.put("huawei_icd.T_DAYLOG_AGENTATTENDANCE", "0点任务");
		a.put("huawei_icd.T_DAYLOG_AGENTCALL", "0点任务");
		a.put("huawei_icd.T_DAYLOG_RPT_AGENTOPRINFO", "0点任务");
		a.put("huawei_icd.T_DAYLOG_RPT_CALLANALYSIS", "0点任务");
		a.put("nettele_RECORD_CUSTOMER", "0点任务");
		a.put("tkpi_S_TRADE", "0点任务");
		a.put("tkpi_S_VERIFYLOG", "0点任务");
		a.put("tkntl_tele.ASSIGN_MODE", "0点任务");
		a.put("tkntl_tele.ASSIGN_RECORD", "0点任务");
		a.put("tkntl_tele.ASSIGN_RECORD_DETAIL", "0点任务");
		a.put("tkntl_tele.ASSIGN_RULE", "0点任务");
		a.put("tkntl_tele.ASSIGN_RULE_DETAIL", "0点任务");
		a.put("tkntl_tele.CALL_RECORDS", "0点任务");
		a.put("tkntl_tele.CUSTOMER_GROUP", "0点任务");
		a.put("tkntl_tele.CUSTOMER_GROUP_DETAIL", "0点任务");
		a.put("tkntl_tele.CUSTOMER_INFO", "0点任务");
		a.put("tkntl_tele.CUSTOMER_INTENTION", "0点任务");
		a.put("tkntl_tele.DYNAMIC_USER_GROUP", "0点任务");
		a.put("tkntl_tele.MODE_CUSTOMER_GROUP", "0点任务");
		a.put("tkntl_tele.MODE_RULE", "0点任务");
		a.put("tkntl_tele.MODE_USER_GROUP", "0点任务");
		a.put("tkntl_tele.SALES_EVENT", "0点任务");
		a.put("tkntl_tele.SALES_LEADS", "0点任务");
		a.put("tkntl_tele.SALES_TRADE", "0点任务");
		a.put("tkntl_tele.SEMI_AUTO_ASSIGN", "0点任务");
		a.put("tkntl_tele.STATIC_USER_GROUP", "0点任务");
		a.put("tkntl_tele.USER_GROUP", "0点任务");
		a.put("tkorahy_tkcoop.COOP_APPLYINSURE", "0点任务");
		a.put("tkorahy_tkcoop.COOP_CUSTOMER", "0点任务");
		a.put("tkctrip_tkctrip.COOP_APPLYINSURE", "0点任务");
		a.put("tkctrip_tkctrip.COOP_CUSTOMER", "0点任务");
		a.put("tkctrip_tkctrip.P_CUSTOMER", "0点任务");
		a.put("tkctrip_tkctrip.P_INSURANT", "0点任务");
		a.put("tkctrip_tkctrip.P_LIFEINSURE", "0点任务");
		a.put("tkorahy_tkinsure.AL_INSURANT", "0点任务");
		a.put("tkorahy_tkinsure.AL_INSURE", "0点任务");
		a.put("tkorahy_tkinsure.AL_POLICYHOLDER", "0点任务");
		a.put("tkorahy_tkinsure.AL_T_INSURE", "0点任务");
		a.put("tkorasol_tkinsure.APP_PRODUCT", "0点任务");
		a.put("tkorasol_tkinsure.CLAIM_COMMONINFO", "0点任务");
		a.put("tkorasol_tkinsure.CLAIM_INFO", "0点任务");
		a.put("tkorasol_tkinsure.CLM_CASE", "0点任务");
		a.put("tkorasol_tkinsure.CLM_INQUIRE", "0点任务");
		a.put("tkorasol_tkinsure.COOP_CHILD_INSURE", "0点任务");
		a.put("tkorasol_tkinsure.CS_INFOCHANGE", "0点任务");
		a.put("tkorasol_tkinsure.CS_LOG", "0点任务");
		a.put("tkorasol_tkinsure.CS_MEMBER_COOP", "0点任务");
		a.put("tkorasol_tkinsure.D_ATTRIBUTION", "0点任务");
		a.put("tkorasol_tkinsure.D_BRANCH", "0点任务");
		a.put("tkorasol_tkinsure.D_CIDTYPE", "0点任务");
		a.put("tkorasol_tkinsure.D_COUPON", "0点任务");
		a.put("tkorasol_tkinsure.D_INFOCHANGEITEM", "0点任务");
		a.put("tkorasol_tkinsure.D_LIFERISKTYPE", "0点任务");
		a.put("tkorasol_tkinsure.D_LIFERISKTYPECOMP", "0点任务");
		a.put("tkorasol_tkinsure.D_PAYWAY", "0点任务");
		a.put("tkorasol_tkinsure.D_RELATION", "0点任务");
		a.put("tkorasol_tkinsure.D_SEAT", "0点任务");
		a.put("tkorasol_tkinsure.D_WORKTYPE", "0点任务");
		a.put("tkorasol_tkinsure.D_WORKTYPENEW", "0点任务");
		a.put("tkorasol_tkinsure.HEALTH_ITEM", "0点任务");
		a.put("tkorasol_tkinsure.POLICY_SPL_DATA", "0点任务");
		a.put("tkorasol_tkinsure.PROVINCE_CITY_AREA", "0点任务");
		a.put("tkorasol_tkinsure.P_APPLYFORM", "0点任务");
		a.put("tkorasol_tkinsure.P_BENEFICIARY", "0点任务");
		a.put("tkorasol_tkinsure.P_BI_DATAEXCHANGE", "0点任务");
		a.put("tkorasol_tkinsure.P_BONUS", "0点任务");
		a.put("tkorasol_tkinsure.P_BONUSHISTORY", "0点任务");
		a.put("tkorasol_tkinsure.P_CLIENTORG", "0点任务");
		a.put("tkorasol_tkinsure.P_COUPONDETAIL", "0点任务");
		a.put("tkorasol_tkinsure.P_COUPONLRTCONFIG", "0点任务");
		a.put("tkorasol_tkinsure.P_CSCPOLICYNO", "0点任务");
		a.put("tkorasol_tkinsure.P_CUSTOMER", "0点任务");
		a.put("tkorasol_tkinsure.P_GOODSEXCHANGE", "0点任务");
		a.put("tkorasol_tkinsure.P_GOODSEXCHANGEDETAIL", "0点任务");
		a.put("tkorasol_tkinsure.P_INFOCHANGE", "0点任务");
		a.put("tkorasol_tkinsure.P_INFOCHANGEPROPERTY", "0点任务");
		a.put("tkorasol_tkinsure.P_INPUTPAY", "0点任务");
		a.put("tkorasol_tkinsure.P_INSURANT", "0点任务");
		a.put("tkorasol_tkinsure.P_INVESTINSUREADD", "0点任务");
		a.put("tkorasol_tkinsure.P_LIFEINSURE", "0点任务");
		a.put("tkorasol_tkinsure.P_LIFEINSURECOMP", "0点任务");
		a.put("tkorasol_tkinsure.P_MEMBERMERGE", "0点任务");
		a.put("tkorasol_tkinsure.P_MEMBERPOLICY", "0点任务");
		a.put("tkorasol_tkinsure.P_MEMBER_LEVEL", "0点任务");
		a.put("tkorasol_tkinsure.P_MEMBER_RIGHTS", "0点任务");
		a.put("tkorasol_tkinsure.P_MESSAGEINFONEW_ACT", "0点任务");
		a.put("tkorasol_tkinsure.P_PAYRECORD", "0点任务");
		a.put("tkorasol_tkinsure.P_POTENTIALCUSTOMER", "0点任务");
		a.put("tkorasol_tkinsure.P_RECOMMENDAPPLIST", "0点任务");
		a.put("tkorasol_tkinsure.P_RECOMMENDPOLICYLIST", "0点任务");
		a.put("tkorasol_tkinsure.P_RENEWAL_PROMPT", "0点任务");
		a.put("tkorasol_tkinsure.P_SEATINVITE", "0点任务");
		a.put("tkorasol_tkinsure.P_TRADE", "0点任务");
		a.put("tkorasol_tkinsure.P_TRAVELINSURESPECIALDATA", "0点任务");
		a.put("tkorasol_tkinsure.SALES_SMS", "0点任务");
		a.put("tkorasol_tkinsure.SALES_SMS_MODEL", "0点任务");
		a.put("tkorasol_tkinsure.TB_GROUNDCHECK", "0点任务");
		a.put("tkorasol_tkinsure.TB_HEALTHINFORM_DETAIL", "0点任务");
		a.put("tkorasol_tkinsure.TB_MANUAL_CHECK", "0点任务");
		a.put("tkorasol_tkinsure.VOTE_VOTERRESULT", "0点任务");
		a.put("tkorasol_tkinsure.WECHAT_POLICY", "0点任务");
		a.put("tkorasol_tkinsure.WECHAT_SUBSCRIPTION", "0点任务");
		a.put("tkcx1_upiccore.COOP_QIHOOCUSTOMER", "0点任务");
		a.put("tkcx_upiccore.GCADJUSTMENTCHARGE", "0点任务");
		a.put("tkcx_upiccore.GCADJUSTMENTITEM", "0点任务");
		a.put("tkcx_upiccore.GCADJUSTMENTMAIN", "0点任务");
		a.put("tkcx_upiccore.GCADJUSTMENTPERSONFEE", "0点任务");
		a.put("tkcx1_upiccore.GCCLAIMMAIN", "0点任务");
		a.put("tkcx_upiccore.GCESTIMATELOSS", "0点任务");
		a.put("tkcx_upiccore.GCPREPAYMAIN", "0点任务");
		a.put("tkcx_upiccore.GCREGISTMAIN", "0点任务");
		a.put("tkcx_upiccore.GCREGISTPOLICY", "0点任务");
		a.put("tkcx_upiccore.GGCODE", "0点任务");
		a.put("tkcx_upiccore.GGCOMPANY", "0点任务");
		a.put("tkcx_upiccore.GGDYNAMICITEMCONFIG", "0点任务");
		a.put("tkcx_upiccore.GGKIND", "0点任务");
		a.put("tkcx1_upiccore.GGRISK", "0点任务");
		a.put("tkcx_upiccore.GGRISKCLASS", "0点任务");
		a.put("tkcx1_upiccore.GSCHANNELPLANCODE", "0点任务");
		a.put("tkcx_upiccore.GSINTERMEDIARYMAIN", "0点任务");
		a.put("tkcx_upiccore.GUENDORENDORHEAD", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOINSURANCE", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOPYCOINSURANCE", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOPYCOMMISSION", "0点任务");
		a.put("tkcx1_upiccore.GUPOLICYCOPYITEMACCILIST", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOPYITEMDYNAMIC", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOPYITEMKIND", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOPYMAIN", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYCOPYRISK", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYITEMACCI", "0点任务");
		a.put("tkcx1_upiccore.GUPOLICYITEMACCILIST", "0点任务");
		a.put("tkcx_upiccore.GUPOLICYITEMKIND", "0点任务");
		a.put("tkcx2_upiccore.GUPOLICYITEMMOTOR", "0点任务");
		a.put("tkcx1_upiccore.GUPOLICYMAIN", "0点任务");
		a.put("tkcx1_upiccore.GUPOLICYRELATEDPARTY", "0点任务");
		a.put("tkcx2_upiccore.GUPOLICYRISK", "0点任务");
		a.put("tkcx1_upiccore.GUPOLICYRISKRELATEDPARTY", "0点任务");
		a.put("tkcx_upiccore.GURENEWALMAIN", "0点任务");
		a.put("tkcx1_upiccore.T_IMPORT_POLICY_RELATION_DIDI", "0点任务");
		a.put("tkcx1_upiccore.T_IMPORT_RELATED_DIDI", "0点任务");
		a.put("tkwebdb_webmanage.PRODUCT", "0点任务");
		a.put("olbi_lifeuser.TOL_BPM_DTL_SRC", "10点任务");
		a.put("olbi_lifeuser.TOL_BZT_DTL_SRC", "10点任务");
		a.put("olbi_lifeuser.TOL_CLAIM_DTL_SRC", "10点任务");
		a.put("olbi_olbi.D_CLIENTORG", "10点任务");
		a.put("olbi_tele.BI_GUANWANG_FROMID", "10点任务");
		a.put("olbi_tele.BI_MULU_CLUE", "10点任务");
		a.put("tkorasol_tkinsure.T_INSURELIST", "t_insurelist表任务");
		a.put("tkorasol_tkinsure.T_INSURELIST_EC", "t_insurelist表任务");
		a.put("tkorasol_tkinsure.P_MEMBER", "依赖顺序表任务");
		a.put("tkorasol_tkinsure.P_MEMBER_UPDATE", "依赖顺序表任务");
	}

	public static void main(String[] args) throws IOException, SQLException {
		// if (args.length < 2) {
		// System.out.println("参数错误!0:sys日志目录;1:导入方式(0:全部导入;1:按照导入日期导入);2:导入日期。");
		// }

		ParserSyslog psl = null;
		if (args.length > 2) {
			psl = new ParserSyslog(args[0], args[1], args[2]);
		} else {
			 psl = new ParserSyslog(args[0], args[1]);
//			psl = new ParserSyslog("C:\\Users\\banzh\\Desktop\\bigdata\\sys", "1","2017-12-20");
		}

		psl.parser();
		System.out.println("完成啦!");
	}

	public ParserSyslog(String abstractPaths, String type) {
		this(abstractPaths, type, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}

	public ParserSyslog(String abstractPaths, String type, String indexDate) {
		this.abstractPaths = abstractPaths;
		this.type = Integer.parseInt(type);
		this.indexDate = indexDate;
	}

	public void parser() throws IOException, SQLException {
		File file = new File(abstractPaths);
		if (!file.isDirectory()) {
			return;
		}
		DBHelper db = new DBHelper();

		File[] listFiles = file.listFiles();
		for (File pf : listFiles) {
			if (type == 1 && !pf.getName().equals(indexDate)) {
				continue;
			}
			System.out.println("...");

			if (!pf.isDirectory()) {
				continue;
			}
			for (File f : pf.listFiles()) {
				String info = readLog(f).replace("'", "\\'");
				String fullname = f.getName().substring(0, f.getName().lastIndexOf(".sys"));
				String taskname = pf.getName().replace("-", "") + "_" + a.get(fullname);
				String tablename = fullname;

				String sql = String.format(
						"INSERT IGNORE INTO `bigdata`.`export_sys_log` (`id`, `taskname`, `tablename`, `info`, `createtime`, `updatetime`) "
								+ "VALUES (null, '%s', '%s', \"%s\", now(), now());\r\n",
						taskname, tablename, info);
				db.pst = db.conn.prepareStatement(sql);
				db.pst.executeUpdate();
			}
		}
		db.close();
	}

	private String readLog(File file) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}
		br.close();
		return sb.toString();
	}
}
