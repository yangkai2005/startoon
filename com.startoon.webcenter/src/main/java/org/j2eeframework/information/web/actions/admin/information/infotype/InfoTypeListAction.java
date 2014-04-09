package org.j2eeframework.information.web.actions.admin.information.infotype;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoTypeService;


public class InfoTypeListAction extends ServiceBasePaginationAction<InfoType, Long> {

	private static final long serialVersionUID = 3126453631478006045L;

	@Resource
	private InfoTypeService infoTypeService;
	
	@Override
	public IGenericService<InfoType, Long> getGenericService()	{
		return infoTypeService;
	}

	@Override
	public void preExecute() {
		
	}

}
