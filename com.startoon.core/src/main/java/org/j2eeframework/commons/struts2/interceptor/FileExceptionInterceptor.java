package org.j2eeframework.commons.struts2.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class FileExceptionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6954657713240256051L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		} catch (Throwable e) {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().write("{message:'false',type:'3'}");
			return null;
		}

	}

}
