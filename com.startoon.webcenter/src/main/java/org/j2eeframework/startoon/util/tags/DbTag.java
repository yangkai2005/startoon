package org.j2eeframework.startoon.util.tags;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.SystemContext;

public class DbTag extends SimpleTagSupport {

	private static final Log log = LogFactory.getLog(DbTag.class);

	protected DataSource dataSource;

	protected Connection connection;

	public DbTag() {
		super();
		dataSource = (DataSource) SystemContext.getApplicationContext().getBean("dataSource");

		try {
			connection = dataSource.getConnection();
			log.debug(" %%% get connection from database pool %%%");
		} catch (SQLException e) {
			log.error("==> get connection from database pool failure:" + "\n" + e.getMessage());
			// throw new DbTagException(e.getMessage(), e.getCause());
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
