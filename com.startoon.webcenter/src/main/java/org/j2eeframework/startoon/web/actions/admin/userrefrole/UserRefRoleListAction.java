package org.j2eeframework.startoon.web.actions.admin.userrefrole;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.UserRefRole;
import org.j2eeframework.startoon.service.UserRefRoleService;


public class UserRefRoleListAction extends ServiceBasePaginationAction<UserRefRole, Long> {

	private static final long serialVersionUID = 4320161446458839926L;

	@Resource
	private UserRefRoleService userRefRoleService;
	
	@Override
	public IGenericService<UserRefRole, Long> getGenericService()	{
		return userRefRoleService;
	}

	@Override
	public void preExecute() {
		
	}

}
