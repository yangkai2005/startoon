package org.j2eeframework.startoon.web.actions.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.AdminUser;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6640004477375720412L;
	private static final Log log = LogFactory.getLog(LogoutAction.class);

	@Override
	@Action(results = { @Result(name = "logout", location = "/admin-login.jsp", type = "redirect") })
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		AdminUser usr = (AdminUser) request.getSession().getAttribute(
				SystemVariables.ADMIN_USER);
		log.info("后台用户注销[" + usr + "]");
		SysContext.clear();
		request.getSession().removeAttribute(SystemVariables.ADMIN_USER);
		request.getSession().removeAttribute(SystemVariables.ADMIN_USER_ID);
		return "logout";
	}

}
