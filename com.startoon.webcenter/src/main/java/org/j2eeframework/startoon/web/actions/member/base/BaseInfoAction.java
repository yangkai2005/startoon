package org.j2eeframework.startoon.web.actions.member.base;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class BaseInfoAction extends ServiceBaseManageAction<Enterprise, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660219204335976543L;

	@Resource
	private EnterpriseService enterpriseService;

	private Enterprise enterprise;
	
	private boolean success;
	
	private String oldPwd;
	private String newPwd;
	

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	@Override
	public Enterprise getModel() {
		return enterprise;
	}

	@Override
	public void prepare() throws Exception {
		Long id = SysContext.getCurrentEnterpriserUser().getId();
		enterprise = getGenericService().getEntityById(id);
	}
	
	public String forwardPassword() {
		return "password";
	}
	
	public String modifyPassword() {
		
		String enOldPwd = EncryptUtil.md5(oldPwd);
		String enNewPwd = EncryptUtil.md5(newPwd);
		
		Long id = SysContext.getCurrentEnterpriserUser().getId();
		Enterprise ent = getGenericService().getEntityById(id);
		
		if(enOldPwd.equals(ent.getPassword())) {
			
			ent.setPassword(enNewPwd);
			
//			getGenericService().update(ent);
			enterpriseService.update(ent);
			success = true;
		} else {
			getActionErrors().add("原密码错误");
		}
		
		return "password";
	}
	
	
	public String update() {
		
		Long id = SysContext.getCurrentEnterpriserUser().getId();
		Enterprise ent = getGenericService().getEntityById(id);
		
		ent.setName(enterprise.getName());
		ent.setNickname(enterprise.getNickname());
		ent.setSex(enterprise.isSex());
		ent.setMobilePhone(enterprise.getMobilePhone());
		ent.setTelephone(enterprise.getTelephone());
//		ent.setEmail(enterprise.getEmail());
		ent.setQq(enterprise.getQq());
		
		getGenericService().update(ent);
		
		SysContext.setEnterpriseUser(ent);
		ServletActionContext.getRequest().getSession().setAttribute(SystemVariables.ENTERPRISE_USER, ent);
	
		success = true;
		
		return "input";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
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
