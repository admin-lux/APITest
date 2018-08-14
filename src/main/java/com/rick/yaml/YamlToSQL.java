package com.rick.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

import com.rick.yaml.model.DbBean;

public class YamlToSQL {

	private static HashMap<String, Object> dsids = new HashMap<>();
	private static HashMap<String, Object> tids = new HashMap<>();
	static {
		dsids.put("huawei", 90);
		dsids.put("nettele", 97);
		dsids.put("olbi", 89);
		dsids.put("tkctrip", 94);
		dsids.put("tkcx", 98);
		dsids.put("tkcx1", 91);
		dsids.put("tkcx2", 93);
		dsids.put("tkntl", 99);
		dsids.put("tkorahy", 92);
		dsids.put("tkorasol", 96);
		dsids.put("tkpi", 95);
		dsids.put("tkwebdb", 100);

		tids.put("tables_all_inc.yml", 6);
		tids.put("tables_olbi_inc.yml", 7);
		tids.put("tables_t_insurelist_all.yml", 8);
		tids.put("tables_tkorasol_memberupdate_inc.yml", 9);
	}

	// C:\Users\banzh\Desktop\config

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\banzh\\Desktop\\config");
		Yaml yaml = new Yaml();

		HashMap<String, String> dss = new HashMap<>();
		HashMap<String, String> ths = new HashMap<>();
		StringBuffer ts = new StringBuffer();

		for (File f : file.listFiles()) {
			if (!f.getName().endsWith("yml")) {
				continue;
			}
			DbBean dbBean = yaml.loadAs(new FileInputStream(f), DbBean.class);
			if (null == dbBean || null == dbBean.getSchemas_list() || dbBean.getSchemas_list().size() <= 0) {
				return;
			}
			dbBean.getSchemas_list().forEach(s -> {

				s.getTable_list().forEach(t -> {
					int index = t.getTable().indexOf(".");
					System.out.println(
							-1 == index ? s.getSchema() : t.getTable().substring(0, t.getTable().indexOf(".")));
					String database_name = -1 == index ? s.getSchema()
							: t.getTable().substring(0, t.getTable().indexOf("."));

					if (!dss.containsKey(database_name)) {
						dss.put(s.getSchema(), String.format(
								"INSERT INTO `bigdata`.`datasources` (`id`, `sys_name`, "
										+ "`database_name`, `source_type`, `user_name`, `pwd`, "
										+ "`connect`, `user_id`, `lastdate`, `state`, "
										+ "`cr_date`, `up_date`) VALUES (null, \"%s\", \"%s\", "
										+ "%s, \"%s\", \"%s\", \"%s\", 1, now(), 1, now(), now());\r\n",
								s.getSchema(), -1 == index ? "" : database_name,
								s.getLink().getUrl().contains("oracle") ? 1 : 2, s.getLink().getUsername(),
								s.getLink().getPassword(), s.getLink().getUrl()));
					}

					ts.append(String.format(
							"INSERT INTO `bigdata`.`imports` (`id`, `datasource_id`, "
									+ "`task_id`, `table_name`, `hbase_name`, `columns`, `num_mappers`, "
									+ "`column_family`, `row_key`, `split_by`, `add_row_key`, "
									+ "`before_import`, `import_type`, `increment_if`, `last_user_id`, "
									+ "`lastdate`, `cr_date`, `up_date`) VALUES (NULL, %s, %s, \"%s\", \"%s\", "
									+ "%s, %s, \"%s\", \"%s\", \"%s\", %s, \"%s\", %s, %s, 1, now(), now(), now());\r\n",
							getDsId(s.getSchema()), getTid(f.getName()), t.getTable(), t.getHbase_table(),
							Utils.isEmpty(t.getColumns(), true) ? null : "\"" + t.getColumns().replace("'", "\\'") + "\"",
							t.getNum_mappers(), t.getColumn_family(), t.getRow_key(), t.getSplit_by(),
							t.getAdd_row_key(), t.getBefore_import(), Utils.isEmpty(t.getWhere()) ? 0 : 1,
							Utils.isEmpty(t.getWhere(), true) ? null : "\"" + t.getWhere() + "\""));

					// ths.put(t.getTable(), t.getHbase_table());
				});
			});
		}

		// File dssFile = new File(file.getAbsolutePath() + File.separator + "dss.sql");
		// Writer dssWriter = new FileWriter(dssFile);
		// dss.forEach((k, v) -> {
		// try {
		// dssWriter.write(v);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// });
		// dssWriter.flush();
		// dssWriter.close();

		File tsFile = new File(file.getAbsolutePath() + File.separator + "ts.sql");
		Writer tsWriter = new FileWriter(tsFile);
		tsWriter.write(ts.toString());
		tsWriter.flush();
		tsWriter.close();

		// File thsFile = new File(file.getAbsolutePath() + File.separator +
		// "ths.properties");
		// Writer thsWriter = new FileWriter(thsFile);
		// ths.forEach((k, v) -> {
		// try {
		// thsWriter.write(String.format("%s=%s", k, v));
		// thsWriter.write("\n");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// });
		// thsWriter.flush();
		// thsWriter.close();

		System.out.println("成功啦");
	}

	private static int getDsId(String schema) {
		return (int) dsids.get(schema);
	}

	private static int getTid(String cn) {
		return (int) tids.get(cn);
	}

}
