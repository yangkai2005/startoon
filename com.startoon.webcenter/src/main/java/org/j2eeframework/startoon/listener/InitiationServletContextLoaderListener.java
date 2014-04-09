package org.j2eeframework.startoon.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.SystemContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 系统启动时启动(关闭)进行相应初始化（清理）
 * 
 * @author william
 * 
 */
public class InitiationServletContextLoaderListener implements ServletContextListener {
	private final static Log log = LogFactory.getLog(InitiationServletContextLoaderListener.class);

	/* 清理数据
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {

	}

	/* 初始化数据
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		log.info("应用程序开始初始化...");
		ServletContext servletContext = event.getServletContext();
		SystemContext.setApplicationContext(WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext));

		SystemConfig.load();

		//上下文
		String contextPath = servletContext.getContextPath();
		SystemConfig.CONTEXT_PATH = contextPath;
		SystemConfig.ROOT_PATH = servletContext.getRealPath("/");

	}

}
