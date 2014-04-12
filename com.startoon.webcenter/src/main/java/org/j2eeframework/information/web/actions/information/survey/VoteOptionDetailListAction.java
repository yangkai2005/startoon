package org.j2eeframework.information.web.actions.information.survey;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.VoteOptionDetail;
import org.j2eeframework.information.service.VoteOptionDetailService;


public class VoteOptionDetailListAction extends ServiceBasePaginationAction<VoteOptionDetail, Long> {

	private static final long serialVersionUID = 3927129722811519087L;

	@Resource
	private VoteOptionDetailService voteOptionDetailService;
	
	@Override
	public IGenericService<VoteOptionDetail, Long> getGenericService()	{
		return voteOptionDetailService;
	}

	@Override
	public void preExecute() {
		
	}

}
