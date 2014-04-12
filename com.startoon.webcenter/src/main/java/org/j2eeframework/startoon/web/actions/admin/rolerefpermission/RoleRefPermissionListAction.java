package org.j2eeframework.startoon.web.actions.admin.rolerefpermission;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.RoleRefPermission;
import org.j2eeframework.startoon.service.RoleRefPermissionService;


public class RoleRefPermissionListAction extends ServiceBasePaginationAction<RoleRefPermission, Long> {

	private static final long serialVersionUID = 1442152071314426436L;

	@Resource
	private RoleRefPermissionService roleRefPermissionService;
	
	@Override
	public IGenericService<RoleRefPermission, Long> getGenericService()	{
		return roleRefPermissionService;
	}

	@Override
	public void preExecute() {
		
	}

}
