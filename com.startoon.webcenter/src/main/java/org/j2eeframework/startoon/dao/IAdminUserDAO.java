package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.AdminUser;

public interface IAdminUserDAO extends IGenericDAO<AdminUser, Long> {

	AdminUser getAdminUserByAccount(String account);

}