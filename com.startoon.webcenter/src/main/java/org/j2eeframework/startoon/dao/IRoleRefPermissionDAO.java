package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.RoleRefPermission;

public interface IRoleRefPermissionDAO extends IGenericDAO<RoleRefPermission, Long> {
	
	public RoleRefPermission findByExample(RoleRefPermission roleRefPermission);

}