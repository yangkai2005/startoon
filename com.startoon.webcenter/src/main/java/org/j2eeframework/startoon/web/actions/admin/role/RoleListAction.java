package org.j2eeframework.startoon.web.actions.admin.role;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Role;
import org.j2eeframework.startoon.service.RoleService;


public class RoleListAction extends ServiceBasePaginationAction<Role, Long> {

	private static final long serialVersionUID = 113513138698326708L;

	@Resource
	private RoleService roleService;
	
	@Override
	public IGenericService<Role, Long> getGenericService()	{
		return roleService;
	}

	@Override
	public void preExecute() {
		
	}

}
