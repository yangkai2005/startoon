package org.j2eeframework.startoon.web.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxLogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1151842114718661147L;

	private static final Log log = LogFactory.getLog(AjaxLogoutAction.class);

	@Override
	public String execute() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Enterprise enterprise = (Enterprise) request.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
			log.info("用户注销[" + enterprise + "]");
			SysContext.clear();
			request.getSession().removeAttribute(SystemVariables.ENTERPRISE_USER);
			request.getSession().removeAttribute(SystemVariables.ENTERPRISE_USER_ID);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("success");
			out.flush();
		} catch (IOException e) {
			log.error("注销失败", e);
		}
		return null;
	}
}
