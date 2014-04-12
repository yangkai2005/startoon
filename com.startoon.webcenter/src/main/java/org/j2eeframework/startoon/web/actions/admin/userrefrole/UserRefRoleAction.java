package org.j2eeframework.startoon.web.actions.admin.userrefrole;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Role;
import org.j2eeframework.startoon.entity.UserRefRole;
import org.j2eeframework.startoon.service.AdminUserService;
import org.j2eeframework.startoon.service.RoleService;
import org.j2eeframework.startoon.service.UserRefRoleService;

@Result(name = "list", location = "/admin/adminuser/admin-user-list.action", type = "redirect")
public class UserRefRoleAction extends ServiceBaseManageAction<UserRefRole, Long> {
	private static final long serialVersionUID = -3143726791819731079L;
	@Resource
	private UserRefRoleService userRefRoleService;
	private UserRefRole userRefRole;

	@Resource
	private AdminUserService adminUserService;
	private AdminUser adminUser;
	private Long userId;

	@Resource
	private RoleService roleService;
	private List<Role> roles;
	private Long roleId;

	@Override
	public IGenericService<UserRefRole, Long> getGenericService() {
		return userRefRoleService;
	}

	public UserRefRole getModel() {
		return userRefRole;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			userRefRole = new UserRefRole();
		} else {
			userRefRole = userRefRoleService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {

		adminUser = adminUserService.getEntityById(userId);

		roles = roleService.getAllEntity();

		UserRefRole ur = userRefRoleService.findByUser(userId);
		if (ur != null) {
			userId = ur.getUser().getId();
			roleId = ur.getRole().getId();
		}

		return super.input();
	}

	@Override
	public String insert() {

		AdminUser au = new AdminUser();
		au.setId(userId);

		Role r = new Role();
		r.setId(roleId);

		userRefRole.setUser(au);
		userRefRole.setRole(r);

		userRefRoleService.add(userRefRole);

		return "list";
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
