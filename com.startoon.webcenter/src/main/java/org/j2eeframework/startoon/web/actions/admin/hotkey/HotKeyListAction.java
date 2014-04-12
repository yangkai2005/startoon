package org.j2eeframework.startoon.web.actions.admin.hotkey;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.HotKey;
import org.j2eeframework.startoon.service.HotKeyService;


public class HotKeyListAction extends ServiceBasePaginationAction<HotKey, Long> {

	private static final long serialVersionUID = 1464889143089155830L;

	@Resource
	private HotKeyService hotKeyService;
	
	@Override
	public IGenericService<HotKey, Long> getGenericService()	{
		return hotKeyService;
	}

	@Override
	public void preExecute() {
		
	}

}
