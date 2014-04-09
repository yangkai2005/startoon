package org.j2eeframework.startoon.web.actions.register;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private static final long serialVersionUID = 7492538587698850675L;
	private static final Log log = LogFactory.getLog(RegisterAction.class);
	@Resource
	private EnterpriseService enterpriseService;
	
	private String email;
	private String nickname;
	private String location;
	private String password;
	private String vcode;
	
	private int sex;
	
	//@Action(results = { @Result(name = "success", location = "/enterprise/enterprise/enterprise-info.jsp"), @Result(name="fail", location="/register.jsp") })
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ccode = (String)request.getSession().getAttribute(SystemVariables.VALIDATE_CODE);
		log.debug(">>>from session ccode:" + ccode);
		if(vcode==null||!ccode.equals(vcode)) {
			return "fail";
		}
		
		Enterprise ent = new Enterprise();
		ent.setEmail(ccode);
		ent.setNickname(nickname);
		ent.setAddress(location);
		ent.setPassword(EncryptUtil.md5(password));
		enterpriseService.insert(ent);
		
		return SUCCESS;
	}

	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	

}
