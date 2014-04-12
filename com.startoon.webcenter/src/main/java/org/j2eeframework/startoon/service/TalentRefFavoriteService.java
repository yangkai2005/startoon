package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ITalentRefFavoriteDAO;
import org.j2eeframework.startoon.entity.TalentRefFavorite;
import org.springframework.stereotype.Service;

@Service
public class TalentRefFavoriteService extends AbstractService<TalentRefFavorite, Long, ITalentRefFavoriteDAO> {
	@Resource
	private ITalentRefFavoriteDAO talentRefFavoriteDAO;

	@Override
	public ITalentRefFavoriteDAO getGenericDAO() {
		return talentRefFavoriteDAO;
	}

	public boolean exist(Long creatorId, Long talentId) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("creatorId", creatorId + "");
		cond.addParameter("talentId", talentId + "");

		int c = getGenericDAO().getCountOfEntitiesByParamCondition(cond);

		return c > 0;
	}
}
