package org.j2eeframework.commons.util;

import org.springframework.context.ApplicationContext;

/**系统环境
 * @author william
 *
 */
public class SystemContext {

	private static ApplicationContext applicationContext; // spring的环境

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SystemContext.applicationContext = applicationContext;
	}

}
