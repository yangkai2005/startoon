package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IVoteOptionDetailDAO;
import org.j2eeframework.information.entity.VoteOptionDetail;
import org.springframework.stereotype.Service;

@Service
public class VoteOptionDetailService extends
		AbstractService<VoteOptionDetail, Long, IVoteOptionDetailDAO> {
	@Resource
	private IVoteOptionDetailDAO voteOptionDetailDAO;

	@Override
	public IVoteOptionDetailDAO getGenericDAO() {
		return voteOptionDetailDAO;
	}
	
	
}
