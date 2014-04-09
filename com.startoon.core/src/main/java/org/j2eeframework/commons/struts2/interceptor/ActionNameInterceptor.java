package org.j2eeframework.commons.struts2.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 取得action名称
 * 
 * @author william
 * 
 */
public class ActionNameInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1491349969545361217L;

	public String intercept(ActionInvocation invocation) throws Exception {
		final ActionContext context = invocation.getInvocationContext();
		String actionName = invocation.getProxy().getActionName();
		String method = invocation.getProxy().getMethod();

		String actionPrefix = actionName.substring(0, actionName.lastIndexOf(method));
		context.getValueStack().setValue("#request.__actionPrefix", actionPrefix);

		return invocation.invoke();
	}
}
