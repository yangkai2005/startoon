package org.j2eeframework.information.web.actions.admin.information.vote;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Vote;
import org.j2eeframework.information.service.VoteService;

public class VoteAction extends ServiceBaseManageAction<Vote, Long> {
	
	private static final long serialVersionUID = 5697554026969518946L;
	
	@Resource
	private VoteService voteService;

	private Vote vote;
	
	private Long infoId;

	@Override
	public IGenericService<Vote, Long> getGenericService() {
		return voteService;
	}

	public Vote getModel() {
		return vote;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			vote = new Vote();
		} else {
			vote = voteService.getEntityById(getRequestId());
		}
	}

	
	public String publish() {
		
		voteService.publish(vote);
		
		return ResultConstants.LIST;
		
	}
	
	public String overdue() {
		vote.setStatus(Vote.STATUS_OVERDUE);
		voteService.update(vote);
		return ResultConstants.LIST;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
}
