package org.j2eeframework.information.web.actions.information.copartnership;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Copartnership;
import org.j2eeframework.information.service.CopartnershipService;


public class CopartnershipListAction extends ServiceBasePaginationAction<Copartnership, Long> {

	private static final long serialVersionUID = 41365749529574612L;

	@Resource
	private CopartnershipService copartnershipService;
	
	@Override
	public IGenericService<Copartnership, Long> getGenericService()	{
		return copartnershipService;
	}

	@Override
	public void preExecute() {
		
		Pager<Copartnership> pager = getPager();
		pager.setPageSize(25);
		
	}

}
