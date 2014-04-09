package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IUserRefRoleDAO;
import org.j2eeframework.startoon.entity.Permission;
import org.j2eeframework.startoon.entity.Role;
import org.j2eeframework.startoon.entity.RoleRefPermission;
import org.j2eeframework.startoon.entity.UserRefRole;
import org.springframework.stereotype.Service;

@Service
public class UserRefRoleService extends AbstractService<UserRefRole, Long, IUserRefRoleDAO>
{
	@Resource
	private IUserRefRoleDAO userRefRoleDAO;
	@Resource
	private PermissionService permissionService;

	@Override
	public IUserRefRoleDAO getGenericDAO()
	{
		return userRefRoleDAO;
	}
	
	public UserRefRole add(UserRefRole userRefRole) {
		
		UserRefRole ur = getGenericDAO().findByUser(userRefRole.getUser().getId());
		if(ur!=null) {
			getGenericDAO().delete(ur);
		}
		
		ur = getGenericDAO().insert(userRefRole);
		
		return userRefRole;
	}
	
	public UserRefRole findByUser(Long userId) {
		return getGenericDAO().findByUser(userId);
	}
	
	public List<Permission> getPermissionByUser(Long userId) {
		
		UserRefRole userRefRole = findByUser(userId);
		
		if(userRefRole==null) {
			return null;
		}
		
		Role role = userRefRole.getRole();
		List<RoleRefPermission> roleRefPermissions = role.getRoleRefPermissions();
		
		List<Permission> permissions = new ArrayList<Permission>();
		for(RoleRefPermission rp : roleRefPermissions) {
			Permission permission = rp.getPermission();
			permissions.add(permission);
		}
		
		return permissions;
		
	}
	
	public Map<Long, List<Permission>> getSortedPermissionByUser(Long userId) {
		List<Permission>  permissions = getPermissionByUser(userId);
		if(permissions==null) {
			return null;
		}
		return permissionService.sort(permissions);
	}
		
		
	
}
