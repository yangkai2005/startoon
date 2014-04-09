package org.j2eeframework.startoon.web.actions.admin.rolerefpermission;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Permission;
import org.j2eeframework.startoon.entity.Role;
import org.j2eeframework.startoon.entity.RoleRefPermission;
import org.j2eeframework.startoon.service.PermissionService;
import org.j2eeframework.startoon.service.RoleRefPermissionService;
import org.j2eeframework.startoon.service.RoleService;

@Result(name = "list", location = "/admin/role/role-list.action", type = "redirect")
public class RoleRefPermissionAction extends ServiceBaseManageAction<RoleRefPermission, Long> {
	
	private static final long serialVersionUID = 8218734247228779758L;
	@Resource
	private RoleRefPermissionService roleRefPermissionService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private RoleService roleService;

	private RoleRefPermission roleRefPermission;

	private Map<Long, List<Permission>> permissionMap;
	
	private Long roleId;
	
	private Role currentRole;
	
	private List<Long> permissionId;

	@Override
	public IGenericService<RoleRefPermission, Long> getGenericService() {
		return roleRefPermissionService;
	}

	public RoleRefPermission getModel() {
		return roleRefPermission;
	}

	public void prepare() throws Exception {

		if (getRequestId() == null || getRequestId() == 0) {
			roleRefPermission = new RoleRefPermission();
		} else {
			roleRefPermission = roleRefPermissionService.getEntityById(getRequestId());
		}

	}
	
	@Override
	public String input() {
		permissionMap = permissionService.getAllPermission();
		currentRole = roleService.getEntityById(roleId);

		List<RoleRefPermission> roleRefPermissions = currentRole.getRoleRefPermissions();

		if(permissionId==null) {
			permissionId = new ArrayList<Long>();
		}
		
		for(RoleRefPermission e : roleRefPermissions) {
			Long pid = e.getPermission().getId();
			permissionId.add(pid);
		}
		
		return super.input();
	}
	
	@Override
	public String insert() {
		roleRefPermissionService.batchAdd(roleId, permissionId);
		return "list";
	}
	
	public RoleRefPermission getRoleRefPermission() {
		return roleRefPermission;
	}

	public void setRoleRefPermission(RoleRefPermission roleRefPermission) {
		this.roleRefPermission = roleRefPermission;
	}

	public Map<Long, List<Permission>> getPermissionMap() {
		return permissionMap;
	}

	public void setPermissionMap(Map<Long, List<Permission>> permissionMap) {
		this.permissionMap = permissionMap;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Role getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(Role currentRole) {
		this.currentRole = currentRole;
	}

	public List<Long> getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(List<Long> permissionId) {
		this.permissionId = permissionId;
	}

}
