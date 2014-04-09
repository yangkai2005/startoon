package org.j2eeframework.startoon.web.actions.admin.ptags;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.PTags;
import org.j2eeframework.startoon.service.PTagsService;


public class PTagsListAction extends ServiceBasePaginationAction<PTags, Long> {

	private static final long serialVersionUID = -9158599731113577051L;

	@Resource
	private PTagsService pTagsService;
	
	@Override
	public IGenericService<PTags, Long> getGenericService()	{
		return pTagsService;
	}

	@Override
	public void preExecute() {
		
	}

}
