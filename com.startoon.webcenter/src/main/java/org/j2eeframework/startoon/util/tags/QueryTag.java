package org.j2eeframework.startoon.util.tags;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QueryTag extends DbTag {

	private static final Log log = LogFactory.getLog(QueryTag.class);

	private String id;

	private String sql;

	private String isMultiple = "true";

	private boolean isMulti = true;

	/***
	 * 传递的参数值： 例 <e:query id="row"
	 * sql="select * from table1 where id=$1 and hits=$2" var="2,100"/> 说明： $1=2
	 * , $2=100 ,依次类推
	 */
	private String var;

	// --- local var ---
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void doTag() throws JspException, IOException {

		try {

			log.debug("-> query sql:" + sql);

			QueryRunner run = new QueryRunner(dataSource);

			MapListHandler handler = new MapListHandler();

			List<Map<String, Object>> list = null;
			try {

				// 获取参数
				if (!StringUtils.isBlank(var)) {
					String[] paraArr = var.split(",");
					for (int i = 0; i < paraArr.length; i++) {
						sql = sql.replace("$" + (i + 1), paraArr[i]);
					}
				}
				log.debug("-> Query SQL: " + sql);
				list = run.query(sql, handler);
				log.debug("查询结果：" + list.size());

			} catch (SQLException e) {
				e.printStackTrace();
				log.error("==>查询标签出错：", e);
			}

			if ("true".equalsIgnoreCase(isMultiple) || "false".equalsIgnoreCase(isMultiple)) {
				isMulti = Boolean.parseBoolean(isMultiple);
			}

			String key = id;

			if (!isMulti) {
				if (list != null && !list.isEmpty()) {
					Map<String, Object> map = list.get(0);
					getJspContext().setAttribute(key, map, PageContext.REQUEST_SCOPE);
				} else {
					getJspContext().setAttribute(key, null);
				}
			} else {
				getJspContext().setAttribute(key, list, PageContext.REQUEST_SCOPE);
			}

		} finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
				log.error("关闭数据库连接失败", e);
			}
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getIsMultiple() {
		return isMultiple;
	}

	public void setIsMultiple(String isMultiple) {
		this.isMultiple = isMultiple;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

}
