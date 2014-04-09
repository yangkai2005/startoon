package org.j2eeframework.commons.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**action路径拦截器
 * @author william
 *
 */
public class ActionPathInterceptor extends AbstractInterceptor 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7766261244581805722L;

	public String intercept(ActionInvocation invocation) throws Exception
	{
		final Object action = invocation.getAction();
		if(action instanceof ActionPathAware)
		{
			String actionName = invocation.getProxy().getActionName();
			String namespace = invocation.getProxy().getNamespace();
			ActionPathAware apw = (ActionPathAware)action;
			apw.setActionName(actionName);
			apw.setNamespace(namespace);
		}
		return invocation.invoke();
	}
}
