package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IVoteDAO;
import org.j2eeframework.information.entity.Vote;
import org.j2eeframework.information.entity.VoteOption;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends AbstractService<Vote, Long, IVoteDAO> {
	@Resource
	private IVoteDAO voteDAO;
	@Resource
	private VoteOptionService voteOptionService;

	@Override
	public IVoteDAO getGenericDAO() {
		return voteDAO;
	}
	
	public List<Vote> getVoteByInfoId(Long infoId) {
		
		Pager<Vote> pager = new Pager<Vote>();
		pager.getParamCondition().addParameter("infoId", infoId + "");
		
		getEntitiesOfPagerByParamCondition(pager);
		
		List<Vote> votes = pager.getItems();
		
		for(Vote v : votes) {
			List<VoteOption> options = v.getVoteOptions();
			int totalVoteCount = 0;
			for(VoteOption option : options) {
				totalVoteCount += option.getVoteCount();
			}
			
			v.setTotalVoteCount(totalVoteCount);
		}
		
		return votes;
		
	}
	
	/**
	 * 发布调查
	 * @param vote
	 */
	public void publish(Vote vote) {
		
		String options = vote.getOptions();
		
		if(options!=null && options.trim().length()>0) {
			
			String[] opts = options.split("\r\n");
			
			for(String opt : opts) {
				VoteOption option = new VoteOption();
				option.setOptionContent(opt);
				option.setVote(vote);
				
				voteOptionService.insert(option);
			}
		}
		
		vote.setStatus(Vote.STATUS_PUBLISH);
		update(vote);
	}
	
	/**
	 * 发布调查
	 * @param infoId
	 */
	public void publishByInfoId(Long infoId) {
		
		List<Vote> votes = getVoteByInfoId(infoId);
		
		for(Vote vote : votes) {
			publish(vote);
		}
		
	}
}
