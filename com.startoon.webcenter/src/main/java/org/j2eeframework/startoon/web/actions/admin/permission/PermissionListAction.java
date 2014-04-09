package org.j2eeframework.startoon.web.actions.admin.permission;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Permission;
import org.j2eeframework.startoon.service.PermissionService;


public class PermissionListAction extends ServiceBasePaginationAction<Permission, Long> {

	private static final long serialVersionUID = -7434902520769275823L;

	@Resource
	private PermissionService permissionService;
	
	@Override
	public IGenericService<Permission, Long> getGenericService()	{
		return permissionService;
	}

	@Override
	public void preExecute() {
		
	}

}
