package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.startoon.dao.IRoleDAO;
import org.j2eeframework.startoon.entity.Role;

@Service
public class RoleService extends AbstractService<Role, Long, IRoleDAO>
{
	@Resource
	private IRoleDAO roleDAO;

	@Override
	public IRoleDAO getGenericDAO()
	{
		return roleDAO;
	}
}
