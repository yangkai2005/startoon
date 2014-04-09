package org.j2eeframework.startoon.web.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 7492538587698850675L;
	private static final Log log = LogFactory.getLog(RegisterAction.class);
	@Resource
	private EnterpriseService enterpriseService;

	@Resource
	private EntInfoService entInfoService;

	private int userType = 0;
	private String email;
	private String nickname;
	private String address;
	private String password;
	private String vcode;
	private EntInfo entInfo;
	private int sex = 0;
	private String name;
	private String linkman;
	private String mobilePhone;

	private long enterpriseId;

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	@Action(results = { @Result(name = "success", location = "/WEB-INF/content/success.jsp"), @Result(name = "fail", location = "/WEB-INF/content/register.jsp") })
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ccode = (String) request.getSession().getAttribute(SystemVariables.VALIDATE_CODE);
		log.debug(">>>from session ccode:" + ccode);
		if (vcode == null || !ccode.equals(vcode)) {
			return "fail";
		}

		boolean exist = enterpriseService.exist(email);
		if (exist) {
			return "fail";
		}

		Enterprise ent = new Enterprise();
		ent.setUserType(userType);
		ent.setSex(sex == 0);
		ent.setAccount(email);
		ent.setEmail(email);
		ent.setNickname(nickname);
		ent.setAddress(address);
		ent.setLinkman(linkman);
		ent.setName(name);
		ent.setMobilePhone(mobilePhone);
		if (userType == Enterprise.USER_TYPE_PERSON) {
			ent.setName(nickname);
		}

		// 拼音
		String pinyin = ent.getNamePinyinByName();
		String firstPinyin = ent.getNameFirstPinyinByName();
		ent.setNamePinyin(pinyin);
		ent.setNameFirstPinyin(firstPinyin);

		ent.setPassword(EncryptUtil.md5(password));

		enterpriseService.insert(ent);

		entInfo = new EntInfo();
		entInfo.setEnterprise(ent);
		entInfo.setIndexImgUrl("/member/images/banner1.jpg");
		entInfoService.insert(entInfo);

		enterpriseId = ent.getId();

		log.debug(">>>用户注册：" + ent);

		request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER, ent);
		request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER_ID, ent.getId());

		return SUCCESS;
	}

	public String checkEmail() {
		try {
			HttpServletResponse rsp = ServletActionContext.getResponse();
			HttpServletRequest req = ServletActionContext.getRequest();
			String email = req.getParameter("email");
			log.debug("注册邮箱帐号验证：" + email);
			Enterprise ent = enterpriseService.getEntByEmail(email);
			if (ent == null) {
				rsp.setContentType("text/html;charset=utf-8");
				PrintWriter out = rsp.getWriter();
				out.write("success");
				out.flush();
			} else {

			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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

	public long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
