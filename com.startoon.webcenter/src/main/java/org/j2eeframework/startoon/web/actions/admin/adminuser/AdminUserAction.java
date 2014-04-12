package org.j2eeframework.startoon.web.actions.admin.adminuser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.service.AdminUserService;

public class AdminUserAction extends ServiceBaseManageAction<AdminUser,Long>
{
	private static final long serialVersionUID = 3547555713273283126L;
	@Resource
	private AdminUserService adminUserService;
	private AdminUser adminUser;
	private String account;
	private String password;
	private String msg;
	private boolean accountRepeat;
	private String oldPwd;
	private String newPwd;
	
	@Override
	public IGenericService<AdminUser, Long> getGenericService()
	{
		return adminUserService;
	}

	public AdminUser getModel()
	{
		return adminUser;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			adminUser = new AdminUser();
		} else
		{
			adminUser = adminUserService.getEntityById(getRequestId());
		}
	}
	
	@Override
	public String insert() {
		
		String name = this.adminUser.getName();
		
		AdminUser adminUser = adminUserService.getAdminUserByAccount(account);
		if(adminUser!=null) {
			accountRepeat = true;
			return super.input();
		}
		
		String pwd = EncryptUtil.md5(password);
		
		adminUser = new AdminUser();
		adminUser.setAccount(account);
		adminUser.setPassword(pwd);
		adminUser.setName(name);
		
		getGenericService().insert(adminUser);
		
		return ResultConstants.LIST;
	}

	public String checkAccount() {
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			
			AdminUser adminUser = adminUserService.getAdminUserByAccount(account);
			if(adminUser==null) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("success");
				out.flush();
			}
			
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public String password() {
		String pwd1 = EncryptUtil.md5(oldPwd);
		String pwd2 = adminUser.getPassword();
		
		if(pwd1.equals(pwd2)) {
			String pwd3 = EncryptUtil.md5(newPwd);
			adminUser.setPassword(pwd3);
			
			getGenericService().update(adminUser);
			
			msg = "success";
		}
		
		return "password";
		
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isAccountRepeat() {
		return accountRepeat;
	}

	public void setAccountRepeat(boolean accountRepeat) {
		this.accountRepeat = accountRepeat;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
}
