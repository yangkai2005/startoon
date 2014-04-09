package org.j2eeframework.startoon.web.actions.admin.help;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Help;
import org.j2eeframework.startoon.service.HelpService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class HelpListAction extends ServiceBasePaginationAction<Help, Long> {

	private static final long serialVersionUID = 4996786626634446423L;

	@Resource
	private HelpService helpService;
	
	@Override
	public IGenericService<Help, Long> getGenericService()	{
		return helpService;
	}

	@Override
	public void preExecute() {
		
	}

}
