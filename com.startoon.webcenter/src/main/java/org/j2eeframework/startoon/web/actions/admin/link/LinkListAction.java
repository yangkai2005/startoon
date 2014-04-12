package org.j2eeframework.startoon.web.actions.admin.link;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Link;
import org.j2eeframework.startoon.service.LinkService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class LinkListAction extends ServiceBasePaginationAction<Link, Long> {

	private static final long serialVersionUID = 3590514723796361466L;

	@Resource
	private LinkService linkService;
	
	@Override
	public IGenericService<Link, Long> getGenericService()	{
		return linkService;
	}

	@Override
	public void preExecute() {
		
	}

}
