package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IVoteOptionDAO;
import org.j2eeframework.information.entity.VoteOption;
import org.springframework.stereotype.Service;

@Service
public class VoteOptionService extends AbstractService<VoteOption, Long, IVoteOptionDAO> {
	@Resource
	private IVoteOptionDAO voteOptionDAO;

	@Override
	public IVoteOptionDAO getGenericDAO() {
		return voteOptionDAO;
	}

	public void addVoteOptionCount(VoteOption option) {
		int c = option.getVoteCount();
		option.setVoteCount(c + 1);
		update(option);
	}

}
