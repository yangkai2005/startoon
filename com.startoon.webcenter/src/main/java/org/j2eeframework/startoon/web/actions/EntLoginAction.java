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
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class EntLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1151842114718661147L;

	private static final Log log = LogFactory.getLog(EntLoginAction.class);

	@Resource
	private EnterpriseService enterpriseService;

	private String account;
	private String password;
	private int userType;
	private long id;
	private String message;

	@Override
	@Action(results = { 
			@Result(name = "success", location = "/enterprise/enterprise/enterprise!info.action?entId=${id}", type = "redirect"), 
			@Result(name = "person", location = "/member/index.action?uid=${id}", type = "redirect"), 
			@Result(name = "fail", location = "/WEB-INF/content/login.jsp")
			})
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();

		Enterprise ent = null;
		try {
			ent = enterpriseService.auth(account, password);

			if (userType != ent.getUserType()) {
				message = "用户类型不正确";
				log.error("登录失败[account:" + account + ", password:" + password + "]:" + message);
				return "fail";
			}
			log.info("登录成功[" + ent + "]");
		} catch (Exception e) {
			log.error("登录失败[account:" + account + ", password" + password + "]", e);
			message = e.getMessage();
			return "fail";
		}

		id = ent.getId();

		SysContext.clear();
		SysContext.setEnterpriseUser(ent);
		request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER, ent);
		request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER_ID, ent.getId());

		request.getSession().removeAttribute(SystemVariables.VALIDATE_CODE);

		if (userType == Enterprise.USER_TYPE_PERSON) {
			return "person";
		}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
