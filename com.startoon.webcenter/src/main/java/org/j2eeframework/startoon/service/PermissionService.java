package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IPermissionDAO;
import org.j2eeframework.startoon.entity.Permission;
import org.springframework.stereotype.Service;

@Service
public class PermissionService extends AbstractService<Permission, Long, IPermissionDAO>
{
	@Resource
	private IPermissionDAO permissionDAO;

	@Override
	public IPermissionDAO getGenericDAO()
	{
		return permissionDAO;
	}
	
	public Map<Long, List<Permission>> getAllPermission() {
		List<Permission> permissions = getAllEntity();
		Map<Long, List<Permission>> map = sort(permissions);
		return map;
	}
	
	public Map<Long, List<Permission>> sort(List<Permission> permissions) {
		
		Map<Long, List<Permission>> map = new HashMap<Long, List<Permission>>();
		
		for(Permission p : permissions) {
			Long category = p.getCategory();
			if(map.containsKey(category)) {
				List<Permission> list = map.get(category);
				list.add(p);
			} else {
				List<Permission> list = new ArrayList<Permission>();
				list.add(p);
				map.put(category, list);
			}
		}
		
		return map;
	}
	
}
