package org.j2eeframework.startoon.web.actions.enterprise.entinfo;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.service.EntInfoService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class EntInfoListAction extends ServiceBasePaginationAction<EntInfo, Long> {

	private static final long serialVersionUID = -3894273454622390845L;

	@Resource
	private EntInfoService entInfoService;
	
	@Override
	public IGenericService<EntInfo, Long> getGenericService()	{
		return entInfoService;
	}

	@Override
	public void preExecute() {
		
	}

}
