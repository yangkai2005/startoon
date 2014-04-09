package org.j2eeframework.startoon.web.actions.admin.linktype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.LinkType;
import org.j2eeframework.startoon.service.LinkTypeService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class LinkTypeListAction extends ServiceBasePaginationAction<LinkType, Long> {

	private static final long serialVersionUID = 6703057423827978174L;

	@Resource
	private LinkTypeService linkTypeService;
	
	@Override
	public IGenericService<LinkType, Long> getGenericService()	{
		return linkTypeService;
	}

	@Override
	public void preExecute() {
		
	}

}
