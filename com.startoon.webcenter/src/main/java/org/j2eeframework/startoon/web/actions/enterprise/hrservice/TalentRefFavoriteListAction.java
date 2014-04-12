package org.j2eeframework.startoon.web.actions.enterprise.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.TalentRefFavorite;
import org.j2eeframework.startoon.service.TalentRefFavoriteService;

public class TalentRefFavoriteListAction extends ServiceBasePaginationAction<TalentRefFavorite, Long> {

	private static final long serialVersionUID = -3006186711335723799L;

	@Resource
	private TalentRefFavoriteService talentRefFavoriteService;

	@Override
	public IGenericService<TalentRefFavorite, Long> getGenericService() {
		return talentRefFavoriteService;
	}

	@Override
	public void preExecute() {

	}

}
