package org.j2eeframework.startoon.web.actions.admin.role;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Role;
import org.j2eeframework.startoon.service.RoleService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class RoleAction extends ServiceBaseManageAction<Role,Long>
{
	private static final long serialVersionUID = -8562181114550973061L;
	@Resource
	private RoleService roleService;
	private Role role;
	@Override
	public IGenericService<Role, Long> getGenericService()
	{
		return roleService;
	}

	public Role getModel()
	{
		return role;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			role = new Role();
		} else
		{
			role = roleService.getEntityById(getRequestId());
		}
	}

}
