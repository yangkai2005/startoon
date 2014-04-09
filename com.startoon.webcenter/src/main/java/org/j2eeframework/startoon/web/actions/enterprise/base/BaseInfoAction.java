package org.j2eeframework.startoon.web.actions.enterprise.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.util.Struts2Utils;

import com.opensymphony.xwork2.ActionSupport;

public class BaseInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1962662267153624380L;

	@Resource
	private EnterpriseService enterpriseService;

	private Enterprise enterprise;

	private String account;
	private String password;
	private String oldpwd;
	private int flag;

	public String modify() {

		enterprise = SysContext.getCurrentEnterpriserUser();

		if (EncryptUtil.md5(oldpwd).equals(enterprise.getPassword())) {
			enterprise.setPassword(EncryptUtil.md5(password));
			enterpriseService.update(enterprise);
			flag = 0;
		} else {
			flag = 1;
		}

		SysContext.setEnterpriseUser(enterprise);
		Struts2Utils.getSession().setAttribute(SystemVariables.ENTERPRISE_USER, enterprise);

		return SUCCESS;
	}

	public String check() {

		try {
			HttpServletResponse rsp = ServletActionContext.getResponse();
			rsp.setContentType("text/html;charset=utf-8");
			PrintWriter out = rsp.getWriter();

			enterprise = enterpriseService.getEntByEmail(account);

			Enterprise currentEnterprise = SysContext.getCurrentEnterpriserUser();

			if (enterprise != null && enterprise.getId() != currentEnterprise.getId()) {
				out.write("failure");
				out.flush();
			} else {
				out.write("success");
				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
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

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
