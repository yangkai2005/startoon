package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IRoleRefPermissionDAO;
import org.j2eeframework.startoon.entity.Permission;
import org.j2eeframework.startoon.entity.Role;
import org.j2eeframework.startoon.entity.RoleRefPermission;
import org.springframework.stereotype.Service;

@Service
public class RoleRefPermissionService extends AbstractService<RoleRefPermission, Long, IRoleRefPermissionDAO>
{
	@Resource
	private IRoleRefPermissionDAO roleRefPermissionDAO;

	@Override
	public IRoleRefPermissionDAO getGenericDAO()
	{
		return roleRefPermissionDAO;
	}
	
	public void batchAdd(Long roleId, List<Long> permissionIds) {
		
		for(Long pid : permissionIds) {
			RoleRefPermission rp = new RoleRefPermission();
			
			Role role = new Role();
			role.setId(roleId);
			
			Permission permission = new Permission();
			permission.setId(pid);
			
			rp.setRole(role);
			rp.setPermission(permission);
			
			saveOrUpdate(rp);
		}
		
	}
	
	@Override
	public RoleRefPermission saveOrUpdate(RoleRefPermission roleRefPermission) {
		RoleRefPermission rp = getGenericDAO().findByExample(roleRefPermission);
		if(rp==null) {
			rp = getGenericDAO().insert(roleRefPermission);
		} 
		
		return rp;
	}
	
	
}
