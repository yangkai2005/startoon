package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.UserRefRole;

public interface IUserRefRoleDAO extends IGenericDAO<UserRefRole, Long> {
	
	public UserRefRole findByExample(UserRefRole userRefRole);

	public UserRefRole findByUser(Long userId);

}