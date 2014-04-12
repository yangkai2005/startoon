package org.j2eeframework.startoon.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Permission;
import org.j2eeframework.startoon.service.AdminUserService;
import org.springframework.stereotype.Controller;

@Controller
public class AdminUserAuthenticationFilter implements Filter {

	private final static Log log = LogFactory.getLog(AdminUserAuthenticationFilter.class);

	/**
	 * 
	 * @param filterConfig
	 *            The filter configuration object
	 */
	public void init(FilterConfig config) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String uri = httpRequest.getRequestURI();
		
		log.debug(">>>请求的URI[" + uri + "]");

		if (requireAuth(httpRequest)) {
			chain.doFilter(request, response);
			return;
		}

		Long userId = (Long) httpRequest.getSession().getAttribute(SystemVariables.ADMIN_USER_ID);
		AdminUser user = (AdminUser) httpRequest.getSession().getAttribute(SystemVariables.ADMIN_USER);

		if (userId == null) {
			String url = httpRequest.getContextPath() + "/WEB-INF/content/admin-login.jsp";
			request.getRequestDispatcher(url).forward(httpRequest, httpResponse);
//			httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin-login.jsp");
			log.info(">>>>> 未登录，不允许进入。");
			return;
		}

		AdminUserService adminUserService = (AdminUserService) SystemContext.getApplicationContext().getBean("adminUserService");
		user = adminUserService.getEntityById(userId);

		log.info("%%% 后台管理用户过滤[AdminUser:" + user + ", adminUserId:" + userId + "] %%%");

		SysContext.setAdminUser(user);

		request.setAttribute("adminUser", user);
		request.setAttribute("currentAdminUser", user);
		request.setAttribute("adminUserId", userId);

		chain.doFilter(request, response);

	}

	private boolean requireAuth(HttpServletRequest request) {

		String uri = request.getRequestURI();
		log.info(">>>getRequestURI:" + uri);
		boolean b = (uri.indexOf("/admin/index.jsp") > 0)
				|| (uri.indexOf("/admin/login.action") > 0)
				|| (uri.indexOf("/admin/logout.action") > 0);

		return b;
	}
	
	private boolean permitted(AdminUser user, String uri) {
		
		Map<Long, List<Permission>> permissions = user.getPermission();
		
		List<Permission> list = new ArrayList<Permission>();
		
		for(Long id : permissions.keySet()) {
			List<Permission> arr = permissions.get(id);
			list.addAll(arr);
		}
		
		List<String> permissionStrList = new ArrayList<String>();
		for(Permission p : list) {
			permissionStrList.add(p.getUrl());
		}
		
		boolean permitted = false;
		for(String permisssionStr : permissionStrList) {
			log.debug(">>>权限认证[" + permisssionStr + "|" + uri + "]");
			
			if(!(permisssionStr.indexOf(uri)<0)) {
				permitted = true;
			}
			
		}
		
		return permitted;
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}