package org.j2eeframework.startoon.web.actions;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.util.email.MailSender;

import com.opensymphony.xwork2.ActionSupport;

public class FindPasswordAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6640004477375720412L;
	private static final Log log = LogFactory.getLog(FindPasswordAction.class);

	@Resource
	private EnterpriseService enterpriseService;

	private String email;
	private int error;

	@Action(results = {
			@Result(name = "error", location = "/find-password.jsp"),
			@Result(name = "success", location = "/find-password-success.jsp", type="redirect") })
	public String execute() {

		Enterprise e = enterpriseService.getEntByEmail(email);
		if (e == null) {
			log.info("无此用户：" + email);
			error = 1;
			return "error";
		}

		String pwd = org.apache.commons.lang.RandomStringUtils.randomNumeric(6);
		
		log.debug(">>>新密码为:" + pwd);
		
		String encryptPwd = EncryptUtil.md5(pwd);
		String content = SystemConfig.MAIL_CONTENT.replace("${password}", pwd);
		MailSender.sendMail(email, content);
		
		e.setPassword(encryptPwd);
		enterpriseService.update(e);
		error = 0;
		return SUCCESS;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

}
