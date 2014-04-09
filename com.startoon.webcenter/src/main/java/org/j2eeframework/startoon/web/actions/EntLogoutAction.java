package org.j2eeframework.startoon.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;

import com.opensymphony.xwork2.ActionSupport;

public class EntLogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1151842114718661147L;

	private static final Log log = LogFactory.getLog(EntLogoutAction.class);

	@Override
	@Action(results = {@Result(name = "success", location = "/information/index.action", type = "redirect")})
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Enterprise enterprise = (Enterprise) request.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
		log.info("企业用户注销[" + enterprise + "]");
		SysContext.clear();
		request.getSession().removeAttribute(SystemVariables.ENTERPRISE_USER);
		request.getSession().removeAttribute(SystemVariables.ENTERPRISE_USER_ID);
		return "success";
	}

}
