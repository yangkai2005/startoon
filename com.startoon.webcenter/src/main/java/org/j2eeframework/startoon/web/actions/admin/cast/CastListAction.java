package org.j2eeframework.startoon.web.actions.admin.cast;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Cast;
import org.j2eeframework.startoon.service.CastService;


public class CastListAction extends ServiceBasePaginationAction<Cast, Long> {

	private static final long serialVersionUID = -3411784336543619501L;

	@Resource
	private CastService castService;
	
	@Override
	public IGenericService<Cast, Long> getGenericService()	{
		return castService;
	}

	@Override
	public void preExecute() {
		
	}

}
