package org.j2eeframework.startoon.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.dao.IAdminUserDAO;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Permission;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService extends AbstractService<AdminUser, Long, IAdminUserDAO> {
	@Resource
	private IAdminUserDAO adminUserDAO;

	@Resource
	private UserRefRoleService userRefRoleService;

	@Override
	public IAdminUserDAO getGenericDAO() {
		return adminUserDAO;
	}

	public AdminUser auth(String account, String password) throws Exception {
		AdminUser usr = null;
		usr = adminUserDAO.getAdminUserByAccount(account);
		
		if(usr==null) {
			throw new Exception("无此用户！");
		}
		String enPwd = EncryptUtil.md5(password);
		
		if(!usr.getPassword().equals(enPwd)) {
			throw new Exception("密码不正确！");
		}
		
		Map<Long, List<Permission>> permission = userRefRoleService.getSortedPermissionByUser(usr.getId());
		usr.setPermission(permission);
		
		return usr;
	}
	
	public AdminUser getAdminUserByAccount(String account) {
		return adminUserDAO.getAdminUserByAccount(account);
	}
}
