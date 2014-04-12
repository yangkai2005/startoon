package org.j2eeframework.information.web.actions.admin.information.voteoptiondetail;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.VoteOptionDetail;
import org.j2eeframework.information.service.VoteOptionDetailService;


public class VoteOptionDetailListAction extends ServiceBasePaginationAction<VoteOptionDetail, Long> {

	private static final long serialVersionUID = -4072957498836924292L;

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
