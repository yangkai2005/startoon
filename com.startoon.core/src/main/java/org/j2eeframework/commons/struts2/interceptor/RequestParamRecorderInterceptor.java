package org.j2eeframework.commons.struts2.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 请求参数记录器
 * 
 * 
 */
public class RequestParamRecorderInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -17292976107876814L;
	private final static Log log = LogFactory.getLog(RequestParamRecorderInterceptor.class);
	public static final String PARAM_RECORDER_NAME = "PARAM_RECORDER_NAME";

	@SuppressWarnings({ "unchecked" })
	public String intercept(ActionInvocation invocation) throws Exception {
		final Object action = invocation.getAction();
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = ServletActionContext.getRequest();

		log.debug("恢复参数为" + request.getParameter("restore_params"));
		// 参数restore_params决定是否需要恢复参数
		if ("true".equalsIgnoreCase(request.getParameter("restore_params"))) {
			// 从session中取得最近一次的请求参数
			Map<String, Object> param = (Map) request.getSession().getAttribute(PARAM_RECORDER_NAME);
			Map<String, Object> contextParam = (Map) context.getParameters();
			if (param != null) {
				for (String key : param.keySet()) {
					contextParam.put(key, param.get(key));
				}
			}
			contextParam.remove("restore_params");
		} else if (action instanceof RememberParamAware) {
			log.debug("记录请求参数至Session中");
			// 记录查询参数
			Map<String, Object> param = (Map) context.getParameters();
			request.getSession().setAttribute(PARAM_RECORDER_NAME, param);
		}

		return invocation.invoke();
	}
}
