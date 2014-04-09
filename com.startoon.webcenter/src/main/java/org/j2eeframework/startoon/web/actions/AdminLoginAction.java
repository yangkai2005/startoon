package org.j2eeframework.startoon.web.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.service.AdminUserService;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6640004477375720412L;
	private static final Log log = LogFactory.getLog(AdminLoginAction.class);

	@Resource
	private AdminUserService adminUserService;
	private String account;
	private String password;
	private String ccode;
	

	@Override
	@Action(value="admin-login", results = { @Result(name = "success", location = "/admin/main/index.jsp", type="redirect"), @Result(name="login", location="/sysadmin") })
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();

		String idCode = (String) request.getSession().getAttribute(SystemVariables.VALIDATE_CODE);
		if (idCode == null) {
			log.info("获取验证码失败：无验证码！");
			return "login";
		}
		log.info("%%% Session中的验证码[" + idCode + "] %%%");

		if (!idCode.equals(ccode)) {
			log.info("验证码校验失败！[验证码为：" + idCode + "，用户输入：" + ccode + "]");
			return "login";
		}

		AdminUser user = null;
		try {
			user = adminUserService.auth(account, password);
		} catch (Exception e) {
			e.printStackTrace();
			return "admin-login";
		}

		SysContext.clear();
		SysContext.setAdminUser(user);
		request.getSession().setAttribute(SystemVariables.ADMIN_USER, user);
		request.getSession().setAttribute(SystemVariables.ADMIN_USER_ID, user.getId());

		request.setAttribute("adminUser", user);

		request.getSession().removeAttribute(SystemVariables.VALIDATE_CODE);

		return SUCCESS;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

}
