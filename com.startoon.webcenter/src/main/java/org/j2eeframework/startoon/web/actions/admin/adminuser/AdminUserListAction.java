package org.j2eeframework.startoon.web.actions.admin.adminuser;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.service.AdminUserService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class AdminUserListAction extends ServiceBasePaginationAction<AdminUser, Long> {

	private static final long serialVersionUID = 5961565069033278653L;

	@Resource
	private AdminUserService adminUserService;
	
	@Override
	public IGenericService<AdminUser, Long> getGenericService()	{
		return adminUserService;
	}

	@Override
	public void preExecute() {
		
	}

}
