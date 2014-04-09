package org.j2eeframework.commons.struts2.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.pager.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 分页支持拦截器
 * 
 * @author william
 * 
 */
public class PagerSupportInterceptor extends AbstractInterceptor {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8689703854840346070L;

	@SuppressWarnings({ "unchecked" })
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		final Object action = invocation.getAction();
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = ServletActionContext.getRequest();

		if (action instanceof PagerAware) {
			// 取得分页查询的访问URL，并且放到ValueStack中
			context.getValueStack().setValue("#request.__RequestURL", request.getRequestURL());
			// 构建pager对象
			Pager pager = new Pager();
			Map<String, Object> m = (Map) context.getParameters();
			pager.putAllParameter(m);
			((PagerAware) action).setPager(pager);
		}
		return invocation.invoke();
	}

}
