package org.j2eeframework.information.web.actions.admin.information.voteoption;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.VoteOption;
import org.j2eeframework.information.service.VoteOptionService;


public class VoteOptionListAction extends ServiceBasePaginationAction<VoteOption, Long> {

	private static final long serialVersionUID = -8189288601997690807L;

	@Resource
	private VoteOptionService voteOptionService;
	
	@Override
	public IGenericService<VoteOption, Long> getGenericService()	{
		return voteOptionService;
	}

	@Override
	public void preExecute() {
		
	}

}
