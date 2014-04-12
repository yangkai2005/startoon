package org.j2eeframework.startoon.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.SystemContext;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.springframework.stereotype.Controller;


@Controller
public class EnterpriseUserAuthenticationFilter implements Filter {

	private final static Log log = LogFactory.getLog(EnterpriseUserAuthenticationFilter.class);

	private EnterpriseService enterpriseService;


	public void destroy() {
	}

	/**
	 * 
	 * @param filterConfig
	 *            The filter configuration object
	 */
	public void init(FilterConfig config) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Long enterprisetId = (Long) httpRequest.getSession().getAttribute(SystemVariables.ENTERPRISE_USER_ID);
		Enterprise enterprise = (Enterprise) httpRequest.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);

		if (enterprisetId == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
			log.info(">>>>> 企业用户未登录，不允许进入。");
			return;
		}
		if(enterprise==null) {
			enterpriseService = (EnterpriseService) SystemContext.getApplicationContext().getBean("enterpriseService");
			enterprise = enterpriseService.getEntityById(enterprisetId);
		}

		log.info("%%%会员过滤[Enterprise:" + enterprise + ", Enterpriset.Id:" + enterprisetId	+ "] %%%");

		SysContext.setEnterpriseUser(enterprise);
		
		request.setAttribute("enterpriseId", enterprisetId);
//		request.setAttribute("enterprise", enterprise);
		request.setAttribute("currentEnterprise", enterprise);

		chain.doFilter(request, response);

	}

}