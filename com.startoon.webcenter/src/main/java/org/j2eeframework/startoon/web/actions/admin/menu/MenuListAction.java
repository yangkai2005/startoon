package org.j2eeframework.startoon.web.actions.admin.menu;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Menu;
import org.j2eeframework.startoon.service.MenuService;


public class MenuListAction extends ServiceBasePaginationAction<Menu, Long> {

	private static final long serialVersionUID = -9088055360181051212L;

	@Resource
	private MenuService menuService;
	
	@Override
	public IGenericService<Menu, Long> getGenericService()	{
		return menuService;
	}

	@Override
	public void preExecute() {
		
	}

}
