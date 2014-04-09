package org.j2eeframework.startoon.web.actions.admin.permission;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Permission;
import org.j2eeframework.startoon.service.PermissionService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class PermissionAction extends ServiceBaseManageAction<Permission,Long>
{
	private static final long serialVersionUID = 727258089176179038L;
	@Resource
	private PermissionService permissionService;
	private Permission permission;
	@Override
	public IGenericService<Permission, Long> getGenericService()
	{
		return permissionService;
	}

	public Permission getModel()
	{
		return permission;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			permission = new Permission();
		} else
		{
			permission = permissionService.getEntityById(getRequestId());
		}
	}

}
