package org.j2eeframework.startoon.web.actions.admin.helpclass;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Helpclass;
import org.j2eeframework.startoon.service.HelpclassService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class HelpclassListAction extends ServiceBasePaginationAction<Helpclass, Long> {

	private static final long serialVersionUID = 277941831484629000L;

	@Resource
	private HelpclassService helpclassService;
	
	@Override
	public IGenericService<Helpclass, Long> getGenericService()	{
		return helpclassService;
	}

	@Override
	public void preExecute() {
		
	}

}
