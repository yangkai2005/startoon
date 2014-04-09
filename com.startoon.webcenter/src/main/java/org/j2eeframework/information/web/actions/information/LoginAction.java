package org.j2eeframework.information.web.actions.information;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2896324791363316696L;

	private static final Log log = LogFactory.getLog(LoginAction.class);

	@Resource
	private EnterpriseService enterpriseService;

	private String userId;
	private String password;
	private int userType;

	@Override
	public String execute() {

		log.debug("资讯平台登录[userId:" + userId + ", password:" + password + "]");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			Enterprise ent = enterpriseService.auth(userId, password, userType);

			SysContext.clear();
			SysContext.setEnterpriseUser(ent);
			request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER, ent);
			request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER_ID, ent.getId());

			out.write("success");
			out.flush();

		} catch (Exception e) {
			log.error("登录失败[account:" + userId + ", password" + password + "]", e);
			String message = e.getMessage();
			addActionError(message);
			out.write("登录失败：" + message);
			out.flush();
		}

		return null;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
