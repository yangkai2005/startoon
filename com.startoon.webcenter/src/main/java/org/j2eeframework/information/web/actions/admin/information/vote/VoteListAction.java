package org.j2eeframework.information.web.actions.admin.information.vote;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Vote;
import org.j2eeframework.information.service.VoteService;


public class VoteListAction extends ServiceBasePaginationAction<Vote, Long> {

	private static final long serialVersionUID = 8990220265512621288L;

	@Resource
	private VoteService voteService;
	
	@Override
	public IGenericService<Vote, Long> getGenericService()	{
		return voteService;
	}

	@Override
	public void preExecute() {
		
	}

}
