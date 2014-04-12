package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IRecommendSupplyDAO;
import org.j2eeframework.startoon.entity.RecommendSupply;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class RecommendSupplyService extends AbstractService<RecommendSupply, Long, IRecommendSupplyDAO>
{
	@Resource
	private IRecommendSupplyDAO recommendSupplyDAO;

	@Override
	public IRecommendSupplyDAO getGenericDAO()
	{
		return recommendSupplyDAO;
	}
}
